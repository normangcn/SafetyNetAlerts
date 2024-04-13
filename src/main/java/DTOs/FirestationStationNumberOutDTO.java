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
public class FirestationStationNumberOutDTO {
	
	
	private List<FirestationStationNumberPeople> people;
	private int kidsCount;
	private int adultsCount;
	
	
	public List<FirestationStationNumberPeople> getPeople() {
		return people;
	}
	public void setPeople(List<FirestationStationNumberPeople> people) {
		this.people = people;
	}


	public int getKidsCount() {
		return kidsCount;
	}
	public void setKidsCount(int kidsCount) {
		this.kidsCount = kidsCount;
	}
	public int getAdultsCount() {
		return adultsCount;
	}
	public void setAdultsCount(int adultsCount) {
		this.adultsCount = adultsCount;
	}
}
class FirestationStationNumberPeople  {
	private String personFirstName;
	private String personLastName;
	private String personAddress;
	
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
	private String personPhoneNumber;
}
