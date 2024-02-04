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
public class FloodStationsStationsOutDTO {

	
	private int stationNumberFirestation;
	
	private String personAddress;
	private String personPhoneNumber;
	private String personFirstName;
	private String personLastName;
	private int age;
	private List <String> medicalRecMedication;
	private List <String> medicalRecAllergies;
	
	public String getPersonFirstName() {
		return personFirstName;
	}
	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}
	public String getPersonLastName() {
		return personLastName;
	}
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public String getPersonPhoneNumber() {
		return personPhoneNumber;
	}
	public void setPersonPhoneNumber(String personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}
	
	public int getStationNumberFirestation() {
		return stationNumberFirestation;
	}
	public void setStationNumberFirestation(int stationNumberFirestation) {
		this.stationNumberFirestation = stationNumberFirestation;
	}
	

	public List<String> getMedicalRecAllergies() {
		return medicalRecAllergies;
	}
	public void setMedicalRecAllergies(List<String> medicalRecAllergies) {
		this.medicalRecAllergies = medicalRecAllergies;
	}

	public List <String> getMedicalRecMedication() {
		return medicalRecMedication;
	}

	public void setMedicalRecMedication(List <String> medicalRecMedication) {
		this.medicalRecMedication = medicalRecMedication;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
