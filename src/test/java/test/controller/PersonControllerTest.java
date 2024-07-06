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
import com.oc.safetynetalerts.controller.PersonController;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author NORMAN Gareth
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SafetyNetAlertsApplication.class)
public class PersonControllerTest {

	@MockBean
	PersonController mockedController;
	@MockBean
	Person mockedModel;
	@Autowired
	TestRestTemplate template;

	@Test
	void contextLoads() throws Exception {
		assertThat(mockedController).isNotNull();
	}

	@Test
	public void delete() {
		String urlDelete = "/person?firstName=John&lastName=Boyd";
		ResponseEntity<Void> response = template.exchange(urlDelete, HttpMethod.DELETE, null, void.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void put() {
		String urlPut = "/person?firstName=John&lastName=Smith";
		ResponseEntity<FireStation> response = template.exchange(urlPut, HttpMethod.PUT, new HttpEntity<>(mockedModel),
				FireStation.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void post() {
		String urlPost = "/person";
		ResponseEntity<FireStation> response = template.exchange(urlPost, HttpMethod.POST,
				new HttpEntity<>(mockedModel), FireStation.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
}
