/**
 * 
 */
package com.oc.safetynetalerts;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

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
	FireStation testFSFromJson = newInstance.extractFireStationsDataFromJsonNode();
	assertThat(testFSFromJson).isNotNull();
	
    }
}
