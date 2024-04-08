/**
 * 
 */
package DTOs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author gareth
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommunityEmailCityOutDTO {
	private String personCity;
	private String personZipCode;
	private String personEmail;
	
	public String getPersonCity() {
		return personCity;
	}
	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}
	public String getPersonZipCode() {
		return personZipCode;
	}
	public void setPersonZipCode(String personZipCode) {
		this.personZipCode = personZipCode;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	
	

}
