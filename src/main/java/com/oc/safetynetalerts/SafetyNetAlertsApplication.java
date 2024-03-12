package com.oc.safetynetalerts;

import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.repository.JsonReaderRepository;
import com.oc.safetynetalerts.utils.DateUtils;


@SpringBootApplication
public class SafetyNetAlertsApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
		JsonReaderRepository repo = new JsonReaderRepository();
		medicalRecords = repo.extractMedicalRecordsDataFromJsonNode();
		LocalDate potato = LocalDate.of(1983, 10, 19);
		int potatoAge = DateUtils.calculateAge(potato);
		System.out.println(potatoAge);
	}
}
