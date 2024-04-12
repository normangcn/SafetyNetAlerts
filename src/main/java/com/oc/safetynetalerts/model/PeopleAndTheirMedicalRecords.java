/**
 * 
 */
package com.oc.safetynetalerts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gareth
 *
 */
public class PeopleAndTheirMedicalRecords {
	private  List<Person> person = new ArrayList<>();
	private  List<MedicalRecord> medicalRecord = new ArrayList<>();
	 
	 public PeopleAndTheirMedicalRecords () {
		 
	 }
	 
	 public PeopleAndTheirMedicalRecords(List<Person> person, List<MedicalRecord> medicalRecord) {
		 super();
		 this.person = person;
		 this.medicalRecord = medicalRecord;
	 }

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public List<MedicalRecord> getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(List<MedicalRecord> medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
}
