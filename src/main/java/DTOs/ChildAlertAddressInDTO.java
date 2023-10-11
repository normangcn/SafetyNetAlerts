/**
 * 
 */
package DTOs;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author gareth
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildAlertAddressInDTO {
	private String personFirstName;
	private String personLastName;
	private String personAddress;	
	private Date medicalRecDOB;
	private String medicalRecFirstName;
	private String medicalRecLastName;
	
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
	public Date getMedicalRecDOB() {
		return medicalRecDOB;
	}
	public void setMedicalRecDOB(Date medicalRecDOB) {
		this.medicalRecDOB = medicalRecDOB;
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
