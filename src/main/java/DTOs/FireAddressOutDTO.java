/**
 * 
 */
package DTOs;

import java.util.List;

import lombok.Data;

/**
 * @author gareth
 *
 */
@Data
public class FireAddressOutDTO {
	private String personAddress;
	private String personFullName;
	private String personPhoneNumber;
	private int stationNumber;
	private int age;
	private List <MedicalRecMedicationAndAllergies> medicalRecMedicationAndAllergies;
	
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public String getPersonFullName() {
		return personFullName;
	}
	public void setPersonFullName(String personFullName) {
		this.personFullName = personFullName;
	}
	public String getPersonPhoneNumber() {
		return personPhoneNumber;
	}
	public void setPersonPhoneNumber(String personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}
	public int getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<MedicalRecMedicationAndAllergies> getMedicalRecMedicationAndAllergies() {
		return medicalRecMedicationAndAllergies;
	}
	public void setMedicalRecMedicationAndAllergies(
			List<MedicalRecMedicationAndAllergies> medicalRecMedicationAndAllergies) {
		this.medicalRecMedicationAndAllergies = medicalRecMedicationAndAllergies;
	}

	
}
