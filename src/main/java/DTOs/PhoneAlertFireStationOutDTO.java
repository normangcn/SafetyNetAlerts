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
public class PhoneAlertFireStationOutDTO {
	private String personPhoneNumber;
	

	public String getPersonPhoneNumber() {
		return personPhoneNumber;
	}
	public void setPersonPhoneNumber(String personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}
}
