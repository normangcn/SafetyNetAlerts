package com.oc.safetynetalerts;

import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.persons;
import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

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
		JsonReaderRepository peopleAndMedicalRecords = new JsonReaderRepository();
		medicalRecords = medicalRecordRepoFromJson.extractMedicalRecordsDataFromJsonNode();
		persons = personRepoFromJson.extractPersonDataFromJsonNode();
		fireStations = fireStationRepoFromJson.extractFireStationsDataFromJsonNode();
		peopleAndtheirMedicalRecords = peopleAndMedicalRecords.combinePeopleAndMedicalRecords();
		
	}
}
