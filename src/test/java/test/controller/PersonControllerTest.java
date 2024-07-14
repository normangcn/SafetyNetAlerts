
package test.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.persons;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.controller.PersonController;
import com.oc.safetynetalerts.model.Person;
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
public class PersonControllerTest {

	@Autowired
	private TestRestTemplate template;

	@MockBean
	private JsonFileWriter jsonFileWriter;

	@InjectMocks
	private PersonController personController;
	private AutoCloseable closeable;
	private List<Person> originalPersons;

	@BeforeEach
	public void setUp() {
		JsonReaderRepository personRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository medicalRecordRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository fireStationRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository peopleAndMedicalRecords = new JsonReaderRepository();
		try {
			medicalRecords = medicalRecordRepoFromJson.extractMedicalRecordsDataFromJsonNode();
			persons = personRepoFromJson.extractPersonDataFromJsonNode();
			fireStations = fireStationRepoFromJson.extractFireStationsDataFromJsonNode();
			peopleAndtheirMedicalRecords = peopleAndMedicalRecords.combinePeopleAndMedicalRecords();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeable = MockitoAnnotations.openMocks(this);
		originalPersons = new ArrayList<>(persons);
		doNothing().when(jsonFileWriter).jsonFileWriter();
	}

	@AfterEach
	public void tearDown() throws Exception {
		closeable.close();
		persons.clear();
		persons.addAll(originalPersons);
	}

	@Test
	void contextLoads() throws Exception {
		assertThat(template).isNotNull();
	}

	@Test
	public void addPerson_ShouldReturnCreated() {
		Person newPerson = new Person("John", "Doe", "123 Main St", "City", "12345", "123-456-7890",
				"john@example.com");
		ResponseEntity<String> response = template.postForEntity("/person", newPerson, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	public void updatePerson_ShouldReturnOk() {
		Person updatePerson = new Person();
		updatePerson.setAddress("456 Elm St");
		updatePerson.setCity("New City");
		updatePerson.setZip("54321");
		updatePerson.setPhone("987-654-3210");
		updatePerson.setEmail("john.doe@example.com");

		String url = "/person?firstName=John&lastName=Doe";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.PUT, new HttpEntity<>(updatePerson),
				String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void deletePerson_ShouldReturnOk() {
		String url = "/person?firstName=John&lastName=Doe";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.DELETE, null, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
