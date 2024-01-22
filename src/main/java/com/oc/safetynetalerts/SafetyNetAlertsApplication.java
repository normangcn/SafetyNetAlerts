package com.oc.safetynetalerts;

import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

@SpringBootApplication
public class SafetyNetAlertsApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
		JsonReaderRepository repo = new JsonReaderRepository();
		List<MedicalRecord> tempMedicalRec = repo.extractMedicalRecordsDataFromJsonNode();
		medicalRecords = tempMedicalRec;
		System.out.println(medicalRecords);
	}

}
