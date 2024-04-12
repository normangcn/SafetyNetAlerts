package com.oc.safetynetalerts;

import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.person;
import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.repository.JsonReaderRepository;


@SpringBootApplication
public class SafetyNetAlertsApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
		JsonReaderRepository personRepo = new JsonReaderRepository();
		JsonReaderRepository medicalRecordRepo = new JsonReaderRepository();
		JsonReaderRepository fireStationRepo = new JsonReaderRepository();
		medicalRecords = medicalRecordRepo.extractMedicalRecordsDataFromJsonNode();
		person = personRepo.extractPersonDataFromJsonNode();
		fireStation = fireStationRepo.extractFireStationsDataFromJsonNode();
		
	}
}
