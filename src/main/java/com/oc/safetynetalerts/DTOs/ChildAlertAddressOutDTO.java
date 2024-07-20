/**
 * 
 */
package com.oc.safetynetalerts.DTOs;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


/**
 * @author gareth
 *
 */
@Data
public class ChildAlertAddressOutDTO {
	/*
	 * une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant à cette
	 * adresse. La liste doit comprendre le prénom et le nom de famille de chaque
	 * enfant, son âge et une liste des autres membres du foyer. S'il n'y a pas
	 * d'enfant, cette url peut renvoyer une chaîne vide.
	 */	
	private String firstName;
	private String lastName;
	private int age = 0;
	private List<FamilyMember> familyMembers = new ArrayList<>();
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
	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	
}
