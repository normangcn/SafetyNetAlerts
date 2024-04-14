/**
 * 
 */
package DTOs;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author gareth
 *
 */
public class MedicalRecMedicationAndAllergies {
	@JsonProperty("medications")
	private List<String> medications = new ArrayList<String>();
	@JsonProperty("allergies")
	private List<String> allergies = new ArrayList<String>();
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
