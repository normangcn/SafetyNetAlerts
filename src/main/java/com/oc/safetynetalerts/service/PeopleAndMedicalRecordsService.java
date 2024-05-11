/**
 * 
 */
package com.oc.safetynetalerts.service;

import java.util.ArrayList;
import java.util.List;

import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.utils.StringUtils;

import static com.oc.safetynetalerts.repository.GlobalRepo.person;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;

/**
 * @author gareth
 *
 */
public class PeopleAndMedicalRecordsService {
public static List<PeopleAndTheirMedicalRecord> personListMergedWithCorrespondingMedicalRecord(){
	List<Person> allPeoples = person;
	List<MedicalRecord> allMedicalRecords = medicalRecords;
	List<MedicalRecord> medicalRecordConcats = new ArrayList<>();
	List<PeopleAndTheirMedicalRecord> mergedLists = new ArrayList<>();
	
	
	for(MedicalRecord medicalRecordElement : allMedicalRecords) {
		MedicalRecord medicalRecordConcat = new MedicalRecord();
		medicalRecordConcat.setFullName(StringUtils.concatNames(medicalRecordElement.getFirstName(), medicalRecordElement.getLastName()));
		medicalRecordConcat.setAllergies(medicalRecordElement.getAllergies());
		medicalRecordConcat.setBirthdate(medicalRecordElement.getBirthdate());
		medicalRecordConcat.setFirstName(medicalRecordElement.getFirstName());
		medicalRecordConcat.setLastName(medicalRecordElement.getLastName());
		medicalRecordConcat.setMedications(medicalRecordElement.getMedications());
		medicalRecordConcats.add(medicalRecordConcat);
	}
		
	for(Person personElement : allPeoples) {
		PeopleAndTheirMedicalRecord mergedPersonAndMedicalRecord = new PeopleAndTheirMedicalRecord();
		mergedPersonAndMedicalRecord.setFullName(StringUtils.concatNames(personElement.getFirstName(), personElement.getLastName()));
		mergedPersonAndMedicalRecord.setAddress(personElement.getAddress());
		mergedPersonAndMedicalRecord.setCity(personElement.getCity());
		mergedPersonAndMedicalRecord.setEmail(personElement.getEmail());
		mergedPersonAndMedicalRecord.setFirstName(personElement.getFirstName());
		mergedPersonAndMedicalRecord.setLastName(personElement.getLastName());
		mergedPersonAndMedicalRecord.setPhone(personElement.getPhone());
		mergedPersonAndMedicalRecord.setZip(personElement.getPhone());
		for(MedicalRecord medicalRecordElementSecondLoop: medicalRecordConcats) {
			if(mergedPersonAndMedicalRecord.getFullName().equals(medicalRecordElementSecondLoop.getFullName())) {	
			mergedPersonAndMedicalRecord.setAllergies(medicalRecordElementSecondLoop.getAllergies());
			mergedPersonAndMedicalRecord.setBirthdate(medicalRecordElementSecondLoop.getBirthdate());
			mergedPersonAndMedicalRecord.setMedications(medicalRecordElementSecondLoop.getMedications());
			mergedLists.add(mergedPersonAndMedicalRecord);
			}
	}

	}
	return mergedLists;
}
}
