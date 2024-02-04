/**
 * 
 */
package DTOs;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author gareth
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildAlertAddressOutDTO {

	private String personFirstName;
	private String personLastName;
	private int kidAge = 0;
	private List<FamilyMember> familyMembers = new ArrayList<>();

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

	public int getKidAge() {
		return kidAge;
	}

	public void setKidAge(int kidAge) {
		this.kidAge = kidAge;
	}

	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}
}
