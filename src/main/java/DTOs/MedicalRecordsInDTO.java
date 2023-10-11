/**
 * 
 */
package DTOs;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author gareth
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalRecordsInDTO {
	
	
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("birthdate")
	private Date birthdate;
	@JsonProperty("medication")
	private List<String> medications;
	@JsonProperty("allergies")
	private List<String> allergies;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
}
