package com.oc.safetynetalerts;

import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.person;
import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndTheirMedicalRecords;
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
		JsonReaderRepository personRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository medicalRecordRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository fireStationRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository peopleAndTheirMedicalRecordsFromJson = new JsonReaderRepository();
		medicalRecords = medicalRecordRepoFromJson.extractMedicalRecordsDataFromJsonNode();
		person = personRepoFromJson.extractPersonDataFromJsonNode();
		fireStation = fireStationRepoFromJson.extractFireStationsDataFromJsonNode();
		peopleAndTheirMedicalRecords = peopleAndTheirMedicalRecordsFromJson.combinePeopleAndMedicalRecords();
		
	}
}
