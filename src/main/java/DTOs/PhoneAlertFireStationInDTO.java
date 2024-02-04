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
	private int stationNumber;
	private String personPhoneNumber;
	
	public int getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}
	public String getPersonPhoneNumber() {
		return personPhoneNumber;
	}
	public void setPersonPhoneNumber(String personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}
}
