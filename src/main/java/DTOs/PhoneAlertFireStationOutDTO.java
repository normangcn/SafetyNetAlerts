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
	private String phone;
	

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
