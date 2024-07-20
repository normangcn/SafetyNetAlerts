/**
 * 
 */
package com.oc.safetynetalerts.DTOs;

import java.util.List;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;

/**
 * @author gareth
 *
 */
public class JsonOutputDTO {
	private List<Person> persons;
	private List<FireStation> firestations;
	private List<MedicalRecord> medicalrecords;
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public List<FireStation> getFirestations() {
		return firestations;
	}
	public void setFirestations(List<FireStation> firestations) {
		this.firestations = firestations;
	}
	public List<MedicalRecord> getMedicalrecords() {
		return medicalrecords;
	}
	public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}
	
	

	}

