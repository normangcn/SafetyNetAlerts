/**
 * 
 */
package com.oc.safetynetalerts.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author gareth
 *
 */
public class PeopleAndTheirMedicalRecords {
	private  List<Person> person = new ArrayList<Person>();
	private  List<MedicalRecord> medicalRecord = new ArrayList<MedicalRecord>();
	 
	 public PeopleAndTheirMedicalRecords () {
		 
	 }
	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	public PeopleAndTheirMedicalRecords withPerson(List<Person> person) {
		this.person = person;
		return this;
		}

	public List<MedicalRecord> getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(List<MedicalRecord> medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public PeopleAndTheirMedicalRecords withMedications(List<MedicalRecord> medicalRecord) {
		this.medicalRecord = medicalRecord;
		return this;
		}
	

	/**
	 * @param person
	 * @param medicalRecord
	 */
	public PeopleAndTheirMedicalRecords(List<Person> person, List<MedicalRecord> medicalRecord) {
		super();
		this.person = person;
		this.medicalRecord = medicalRecord;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(medicalRecord, person);
	}
	
	/**
	 * @param index
	 * @param element
	 * @return
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public Person set(int index, Person element) {
		return person.set(index, element);
	}
	/**
	 * @param index
	 * @param element
	 * @return
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public MedicalRecord set(int index, MedicalRecord element) {
		return medicalRecord.set(index, element);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeopleAndTheirMedicalRecords other = (PeopleAndTheirMedicalRecords) obj;
		return Objects.equals(medicalRecord, other.medicalRecord) && Objects.equals(person, other.person);
	}
	@Override
	public String toString() {
		return "PeopleAndTheirMedicalRecords [person=" + person + ", medicalRecord=" + medicalRecord + ", getPerson()="
				+ getPerson() + ", getMedicalRecord()=" + getMedicalRecord() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
