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

	private List<MedicationOnly> medications;
	private List<AllergiesOnly> allergies;
	public List<MedicationOnly> getMedications() {
		return medications;
	}
	public void setMedications(List<MedicationOnly> medications) {
		this.medications = medications;
	}
	public List<AllergiesOnly> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<AllergiesOnly> allergies) {
		this.allergies = allergies;
	}

	
}
