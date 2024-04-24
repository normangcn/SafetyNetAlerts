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
	private int stationNumber;
	private List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> people;/*La liste doit inclure le nom, le numéro de
	 * téléphone, l'âge et les antécédents médicaux (médicaments, posologie et
	 * allergies) de chaque personne.*/
	public int getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}
	public List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> getPeople() {
		return people;
	}
	public void setPeople(List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> people) {
		this.people = people;
	}

	
}
