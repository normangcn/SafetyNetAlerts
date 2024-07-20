/**
 * 
 */
package com.oc.safetynetalerts.utils;
import static com.oc.safetynetalerts.repository.GlobalRepo.persons;
import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;

import java.io.FileWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oc.safetynetalerts.DTOs.JsonOutputDTO;
import com.oc.safetynetalerts.service.ObjectMapperService;

/**
 * @author gareth
 *
 */
public class JsonFileWriter {
	
	public void jsonFileWriter(){
		
    try (FileWriter fileWriter = new FileWriter("src/main/resources/data.json")) {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonOutputDTO objectToWrite = new JsonOutputDTO();
    	objectToWrite.setPersons(persons);
    	objectToWrite.setFirestations(fireStations);
    	objectToWrite.setMedicalrecords(medicalRecords);
    	String json = mapper.writeValueAsString(objectToWrite);
        fileWriter.write(json);
        fileWriter.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
