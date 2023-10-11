/**
 * 
 */
package com.oc.safetynetalerts.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oc.safetynetalerts.service.ObjectMapperService;

import DTOs.FireStationsInDTO;
import DTOs.MedicalRecordsInDTO;
import DTOs.PersonInDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */

  @Component
  @RequestMapping
  @Slf4j
  public class JsonReaderRepository {
    public static JsonNode StarterJsonFileReader() {
    ObjectMapper mapper = ObjectMapperService.getInstance();
    JsonNode JsonFileContent = null;
	try {
	    File jsonFile = new File("src/main/resources/data.json").getAbsoluteFile();
	    JsonFileContent = ((JsonNode)mapper.readTree(jsonFile));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return JsonFileContent;
    }
    
    
    public static PersonInDTO extractPersonDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	final JsonNode personFromJasonFileJsonNode = StarterJsonFileReader().get("person");
    	PersonInDTO personFromJsonNodeToDTO = mapper.treeToValue(personFromJasonFileJsonNode, PersonInDTO.class);
		return personFromJsonNodeToDTO;
    }
    
    public FireStationsInDTO extractFireStationsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode fireStationsFromJasonFileJsonNode = StarterJsonFileReader().get("firestations");
    	FireStationsInDTO fireStationsFromJsonNodeToDTO = mapper.treeToValue(fireStationsFromJasonFileJsonNode, FireStationsInDTO.class);
		return fireStationsFromJsonNodeToDTO;
    }
    
    public MedicalRecordsInDTO extractMedicalRecordsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	final JsonNode medicalRecordsFromJasonFileJsonNode = StarterJsonFileReader().get("medicalrecords");
    	MedicalRecordsInDTO medicalRecordsFromJsonNodeToDTO = mapper.treeToValue(medicalRecordsFromJasonFileJsonNode, MedicalRecordsInDTO.class);
		return medicalRecordsFromJsonNodeToDTO;
    }
    
}