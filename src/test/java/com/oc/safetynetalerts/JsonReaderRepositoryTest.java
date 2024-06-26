/**
 * 
 */
package com.oc.safetynetalerts;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

/**
 * @author NORMAN Gareth
 *
 */
/* @RunWith(SpringRunner.class) */
/*
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes =
 * Application.class)
 * 
 * @AutoConfigureMockMvc
 * 
 * @TestPropertySource(locations =
 * "classpath:application-integrationtest.properties")
 */
@SpringBootTest
public class JsonReaderRepositoryTest{

    @Test
    public void extractFireStationsDataFromJsonNodeTest() throws JsonParseException, JsonMappingException, IOException {
	JsonReaderRepository newInstance = new JsonReaderRepository();
	List<FireStation> testFSFromJson = newInstance.extractFireStationsDataFromJsonNode();
	assertThat(testFSFromJson).isNotNull();
	
    }
}
