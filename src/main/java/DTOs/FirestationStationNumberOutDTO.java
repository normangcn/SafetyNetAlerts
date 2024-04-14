/**
 * 
 */
package DTOs;


import java.util.ArrayList;
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
	public void addPeople(FirestationStationNumberPeople person) {
        if (people == null) {
            people = new ArrayList<>();
        }

        people.add(person);
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
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
