/**
 * 
 */
package DTOs;

import java.util.List;


/**
 * @author gareth
 *
 */
public class MedicationAndAllergiesOnly {

	public class Allergies {

	}
	
	public class Medication {

	}
	private List<Medication> medications;
	private List<Allergies> allergies;
	public List<Medication> getMedications() {
		return medications;
	}
	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
	public List<Allergies> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<Allergies> allergies) {
		this.allergies = allergies;
	}
	
}
