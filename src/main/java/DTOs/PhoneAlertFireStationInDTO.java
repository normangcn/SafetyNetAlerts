/**
 * 
 */
package DTOs;

import lombok.Data;

/**
 * @author gareth
 *
 */

@Data
public class PhoneAlertFireStationInDTO {
	private String addressFirestation;
	private int stationNumber;
	private String personAddress;
	private String personPhoneNumber;
	
	public String getAddressFirestation() {
		return addressFirestation;
	}
	public void setAddressFirestation(String addressFirestation) {
		this.addressFirestation = addressFirestation;
	}
	public int getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
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
	
	
	
}
