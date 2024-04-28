/**
 * 
 */
package com.oc.safetynetalerts.service;

import java.util.ArrayList;
import java.util.List;

import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecords;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.utils.StringUtils;

import static com.oc.safetynetalerts.repository.GlobalRepo.person;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;

/**
 * @author gareth
 *
 */
public class PeopleAndMedicalRecordsService {
public List<PeopleAndTheirMedicalRecords> personListMergedWithCorrespondingMedicalRecord(){
	List<Person> allPeoples = person;
	List<MedicalRecord> allMedicalRecords = medicalRecords;
	List<MedicalRecord> medicalRecordConcats = new ArrayList<>();
	List<PeopleAndTheirMedicalRecords> mergedLists = new ArrayList<>();
	PeopleAndTheirMedicalRecords mergedPersonAndMedicalRecord = new PeopleAndTheirMedicalRecords();
	MedicalRecord medicalRecordConcat = new MedicalRecord();
	
	for(MedicalRecord medicalRecordElement : allMedicalRecords) {
		medicalRecordConcat.setFullName(StringUtils.concatNames(medicalRecordElement.getFirstName(), medicalRecordElement.getLastName()));
		medicalRecordConcat.setAllergies(medicalRecordElement.getAllergies());
		medicalRecordConcat.setBirthdate(medicalRecordElement.getBirthdate());
		medicalRecordConcat.setFirstName(medicalRecordElement.getFirstName());
		medicalRecordConcat.setLastName(medicalRecordElement.getLastName());
		medicalRecordConcat.setMedications(medicalRecordElement.getMedications());
		medicalRecordConcats.add(medicalRecordConcat);
	}
		
	for(Person personElement : allPeoples) {
		mergedPersonAndMedicalRecord.setFullName(StringUtils.concatNames(personElement.getFirstName(), personElement.getLastName()));
		for(MedicalRecord medicalRecordElement: medicalRecordConcats) {
			if(mergedPersonAndMedicalRecord.getFullName() == medicalRecordElement.getFullName()) {
			mergedPersonAndMedicalRecord.setAddress(personElement.getAddress());
			mergedPersonAndMedicalRecord.setCity(personElement.getCity());
			mergedPersonAndMedicalRecord.setEmail(personElement.getEmail());
			mergedPersonAndMedicalRecord.setFirstName(personElement.getFirstName());
			mergedPersonAndMedicalRecord.setLastName(personElement.getLastName());
			mergedPersonAndMedicalRecord.setPhone(personElement.getPhone());
			mergedPersonAndMedicalRecord.setZip(personElement.getPhone());
			mergedPersonAndMedicalRecord.setAllergies(medicalRecordElement.getAllergies());
			mergedPersonAndMedicalRecord.setBirthdate(medicalRecordElement.getBirthdate());
			mergedPersonAndMedicalRecord.setMedications(medicalRecordElement.getMedications());
			}
		}
				
	}
	return mergedLists;
}
}
