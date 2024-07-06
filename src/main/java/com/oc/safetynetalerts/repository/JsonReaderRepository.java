/**
 * 
 */
package com.oc.safetynetalerts.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.service.ObjectMapperService;
import com.oc.safetynetalerts.service.PeopleAndMedicalRecordsService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */

  @Component
  @RequestMapping
  @Slf4j
  public class JsonReaderRepository {    
	public static JsonNode starterJsonFileReader() {
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
    
    public List<Person> extractPersonDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode personFromJasonFileJsonNode = starterJsonFileReader().get("persons");
    	List<Person> personFromJsonNode = new ArrayList<>();
    	for(JsonNode o : personFromJasonFileJsonNode) {
    		String str= mapper.writeValueAsString(o);
    		Person personID = mapper.readValue(str,  Person.class);
    		personID.setId(UUID.randomUUID());
    		personFromJsonNode.add(mapper.readValue(str, Person.class));
    	}    	
    	return personFromJsonNode;
    }
    
    public List<FireStation> extractFireStationsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode fireStationsFromJasonFileJsonNode = starterJsonFileReader().get("firestations");
    	List<FireStation> fireStationsFromJsonNode = new ArrayList<>();
        for(JsonNode o : fireStationsFromJasonFileJsonNode) {
    		String str= mapper.writeValueAsString(o);
    		FireStation stationID = mapper.readValue(str, FireStation.class);
    		stationID.setId(UUID.randomUUID());
    		fireStationsFromJsonNode.add(mapper.readValue(str, FireStation.class));
    	}    	
    	return fireStationsFromJsonNode;
    }
    
    public List<MedicalRecord> extractMedicalRecordsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode medicalRecordsFromJasonFileJsonNode = starterJsonFileReader().get("medicalrecords");
    	List<MedicalRecord> medicalRecordsFromJsonNode = new ArrayList<>();
        for(JsonNode o : medicalRecordsFromJasonFileJsonNode) {
    		String str= mapper.writeValueAsString(o);
    		MedicalRecord recordID = mapper.readValue(str, MedicalRecord.class);
    		recordID.setId(UUID.randomUUID());
    		medicalRecordsFromJsonNode.add(mapper.readValue(str, MedicalRecord.class));    		
    	}   	
    	return medicalRecordsFromJsonNode;
    }
	
	public List<PeopleAndTheirMedicalRecord> combinePeopleAndMedicalRecords() {
		List<PeopleAndTheirMedicalRecord> peopleAndTheirMedicalRecords = new ArrayList<PeopleAndTheirMedicalRecord>();
		peopleAndTheirMedicalRecords = PeopleAndMedicalRecordsService.personListMergedWithCorrespondingMedicalRecord();
		return peopleAndTheirMedicalRecords;
	}
	
}