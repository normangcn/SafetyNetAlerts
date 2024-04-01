/**
 * 
 */
package com.oc.safetynetalerts.integrationtests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oc.safetynetalerts.service.PersonService;

/**
 * @author gareth
 *
 */

@SpringBootTest
public class PersonControllerIntegrationTest {
	@Autowired
	PersonService personService;
	@Test
	void contextLoads() {
		assertThat(personService).isNotNull();
	}
}
