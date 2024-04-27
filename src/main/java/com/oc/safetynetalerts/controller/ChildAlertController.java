/**
 * 
 */
package com.oc.safetynetalerts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.person;

import java.util.ArrayList;
import java.util.List;

import DTOs.ChildAlertAddressOutDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/childAlert")
@RestController
@Slf4j
public class ChildAlertController {
	/*
	 * http://localhost:8080/childAlert?address=<address> Cette url doit retourner
	 * une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant à cette
	 * adresse. La liste doit comprendre le prénom et le nom de famille de chaque
	 * enfant, son âge et une liste des autres membres du foyer. S'il n'y a pas
	 * d'enfant, cette url peut renvoyer une chaîne vide.
	 */
	@GetMapping(value = "/{home_address}")
	@ResponseBody
	public ChildAlertAddressOutDTO childAlertAddress(@PathVariable("home_address") String address) {
		ChildAlertAddressOutDTO responseDTO = new ChildAlertAddressOutDTO();
		List<Person> allPeople = person;
		List<MedicalRecord> allMedicalRecord = medicalRecords;
		List<Person> filteredPeople = new ArrayList<>();
		
		for(Person personElement : allPeople) {
			if(personElement.getAddress().equals(String.valueOf(address))) {
				filteredPeople.add(personElement);
			}
		}
		
		return responseDTO;
		
	}

}
