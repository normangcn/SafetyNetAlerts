package test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.controller.FireStationController;
import com.oc.safetynetalerts.model.FireStation;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author NORMAN Gareth
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SafetyNetAlertsApplication.class)
public class FireStationControllerTest {

	@MockBean
	FireStationController mockedController;
	@MockBean
	FireStation mockedModel;
	@Autowired
	TestRestTemplate template;

	@Test
	void contextLoads() throws Exception {
		assertThat(mockedController).isNotNull();
	}

	@Test
	public void delete() {
		String urlDelete = "/firestation?station=3&address=1509 Culver St";
		ResponseEntity<Void> response = template.exchange(urlDelete, HttpMethod.DELETE, null, void.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void put() {
		String urlPut = "/firestation?address=1509 Culver St";
		ResponseEntity<FireStation> response = template.exchange(urlPut, HttpMethod.PUT, new HttpEntity<>(mockedModel),
				FireStation.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void post() {
		String urlPost = "/firestation";
		ResponseEntity<FireStation> response = template.exchange(urlPost, HttpMethod.POST,
				new HttpEntity<>(mockedModel), FireStation.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
}
