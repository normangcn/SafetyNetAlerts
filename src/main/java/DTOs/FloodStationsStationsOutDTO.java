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
public class FloodStationsStationsOutDTO {

	
	private int stationNumberFirestation;
	
	private String address;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private int age;
	private List <String> medications;
	private List <String> allergies;
	public int getStationNumberFirestation() {
		return stationNumberFirestation;
	}
	public void setStationNumberFirestation(int stationNumberFirestation) {
		this.stationNumberFirestation = stationNumberFirestation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
