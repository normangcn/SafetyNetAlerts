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
	private String stationNumber;
	private List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> people;
	
	public String getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}
	public List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> getPeople() {
		return people;
	}
	public void setPeople(List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> people) {
		this.people = people;
	}

	
}
