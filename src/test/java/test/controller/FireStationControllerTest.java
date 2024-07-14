package test.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.DTOs.FirestationStationNumberOutDTO;
import com.oc.safetynetalerts.controller.FireStationController;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.repository.JsonReaderRepository;
import com.oc.safetynetalerts.utils.JsonFileWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SafetyNetAlertsApplication.class)
public class FireStationControllerTest {

	@Autowired
	private TestRestTemplate template;

	@MockBean
	private JsonFileWriter jsonFileWriter;

	@InjectMocks
	private FireStationController fireStationController;
	private AutoCloseable closeable;
	private List<FireStation> originalFireStations;

	@BeforeEach
	public void setUp() {
		JsonReaderRepository fireStationRepoFromJson = new JsonReaderRepository();
		try {
			fireStations = fireStationRepoFromJson.extractFireStationsDataFromJsonNode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeable = MockitoAnnotations.openMocks(this);
		originalFireStations = new ArrayList<>(fireStations);
		doNothing().when(jsonFileWriter).jsonFileWriter();
	}

	@AfterEach
	public void tearDown() throws Exception {
		closeable.close();
		fireStations.clear();
		fireStations.addAll(originalFireStations);
	}

	@Test
	void contextLoads() throws Exception {
		assertThat(template).isNotNull();
	}

	@Test
	public void addFireStation_ShouldReturnCreated() {
		FireStation newFireStation = new FireStation("123 Main St", "1");
		ResponseEntity<String> response = template.postForEntity("/firestation", newFireStation, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	public void updateFireStation_ShouldReturnOk() {
		FireStation updateFireStation = new FireStation("456 Elm St", "2");

		String url = "/firestation?address=123 Main St";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.PUT, new HttpEntity<>(updateFireStation),
				String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void deleteFireStation_ShouldReturnOk() {
		String url = "/firestation?station=1&address=123 Main St";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.DELETE, null, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void getFireStation_ShouldReturnFireStation() {
		String stationNumber = "1";
		ResponseEntity<FirestationStationNumberOutDTO> response = template
				.getForEntity("/firestation?stationNumber=" + stationNumber, FirestationStationNumberOutDTO.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertThat(response.getBody()).isNotNull();
	}
}
