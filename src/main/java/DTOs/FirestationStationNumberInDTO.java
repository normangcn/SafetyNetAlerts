/**
 * 
 */
package DTOs;

import java.util.Date;

import lombok.Data;

/**
 * @author gareth
 *
 */
@Data
public class FirestationStationNumberInDTO {
	private String addressFirestation;
	private int stationNumberFirestation;
	
	private String personFirstName;
	private String personLastName;
	private String personAddress;
	private String personPhoneNumber;
	
	private Date medicalRecDOB;
	private String medicalRecFirstName;
	private String medicalRecLastName;
	
	public String getAddressFirestation() {
		return addressFirestation;
	}
	public void setAddressFirestation(String addressFirestation) {
		this.addressFirestation = addressFirestation;
	}
	public int getStationNumberFirestation() {
		return stationNumberFirestation;
	}
	public void setStationNumberFirestation(int stationNumberFirestation) {
		this.stationNumberFirestation = stationNumberFirestation;
	}
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
	public Date getMedicalRecDOB() {
		return medicalRecDOB;
	}
	public void setMedicalRecDOB(Date date) {
		this.medicalRecDOB = date;
	}
	public String getMedicalRecFirstName() {
		return medicalRecFirstName;
	}
	public void setMedicalRecFirstName(String medicalRecFirstName) {
		this.medicalRecFirstName = medicalRecFirstName;
	}
	public String getMedicalRecLastName() {
		return medicalRecLastName;
	}
	public void setMedicalRecLastName(String medicalRecLastName) {
		this.medicalRecLastName = medicalRecLastName;
	}
	
	
}
