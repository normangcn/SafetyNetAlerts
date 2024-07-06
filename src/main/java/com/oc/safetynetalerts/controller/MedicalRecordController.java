/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.MedicalRecord;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/medicalrecord")
@RestController
@Slf4j
public class MedicalRecordController {
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String addMedicalRecord(@RequestBody MedicalRecord newMedicalRecord) {
		medicalRecords.add(newMedicalRecord);
		return "Person added as:" + newMedicalRecord;
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public String updateMedicalRecord(@RequestParam String firstName, @RequestParam String lastName, @RequestBody MedicalRecord updateMedicalRecord) {
		for(MedicalRecord medicalRecordElement:medicalRecords) {
	        if(medicalRecordElement.getFirstName().equals(firstName)&&medicalRecordElement.getLastName().equals(lastName)) {
	        	medicalRecordElement.setBirthdate(updateMedicalRecord.getBirthdate());
	        	medicalRecordElement.setMedications(updateMedicalRecord.getMedications());
	        	medicalRecordElement.setAllergies(updateMedicalRecord.getAllergies());	        	
	        }
	    }
		return "Medical record for " + firstName +" " + lastName + " updated.";
	}

	@DeleteMapping()
	@ResponseStatus(HttpStatus.OK)
	public void deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
		List<MedicalRecord> deleteMedicalRecords = new ArrayList<>();
		MedicalRecord deleteMedicalRecord = new MedicalRecord();
		deleteMedicalRecord.setFirstName(firstName);
		deleteMedicalRecord.setLastName(lastName);
		deleteMedicalRecords.add(deleteMedicalRecord);
		medicalRecords.removeAll(deleteMedicalRecords);
	}
}
