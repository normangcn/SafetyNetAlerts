/**
 * 
 */
package com.oc.safetynetalerts.DTOs;

import java.util.List;

/**
 * @author gareth
 *
 */
public class PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies {

	private String fullName;
	private String phone;
	private int age;
	private List<MedicationAndAllergiesOnly>MedicationAndAllergies;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<MedicationAndAllergiesOnly> getMedicationAndAllergies() {
		return MedicationAndAllergies;
	}
	public void setMedicationAndAllergies(List<MedicationAndAllergiesOnly> medicationAndAllergies) {
		MedicationAndAllergies = medicationAndAllergies;
	}
	
}
