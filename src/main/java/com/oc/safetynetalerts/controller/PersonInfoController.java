/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

import DTOs.PersonInfoFirstNameAndLastNameOutDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/personInfo")
@RestController
@Slf4j
public class PersonInfoController {
	/*
	 * http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>
	 * Cette url doit retourner le nom, l'adresse, l'âge, l'adresse mail et les
	 * antécédents médicaux (médicaments, posologie, allergies) de chaque habitant.
	 * Si plusieurs personnes portent le même nom, elles doivent toutes apparaître.
	 */
	@GetMapping()
	@ResponseBody
	public  List<PersonInfoFirstNameAndLastNameOutDTO> personInfo(@RequestParam String firstName, @RequestParam String lastName) {
		List<PersonInfoFirstNameAndLastNameOutDTO> responseDTO = new ArrayList<PersonInfoFirstNameAndLastNameOutDTO>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndtheirMedicalRecords = peopleAndtheirMedicalRecords;		
		LocalDate birthDate = null;
		
		for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElement: allPeopleAndtheirMedicalRecords) {
			if(peopleAndTheirMedicalRecordElement.getFirstName().equals(String.valueOf(firstName)) && peopleAndTheirMedicalRecordElement.getLastName().equals(String.valueOf(lastName))) {
				PersonInfoFirstNameAndLastNameOutDTO filteredPerson = new PersonInfoFirstNameAndLastNameOutDTO();
			filteredPerson.setFirstName(peopleAndTheirMedicalRecordElement.getFirstName());
			filteredPerson.setLastName(peopleAndTheirMedicalRecordElement.getLastName());
			filteredPerson.setAddress(lastName);
			birthDate = DateUtils.stringToLocalDateFormatter(peopleAndTheirMedicalRecordElement.getBirthdate());
			filteredPerson.setAge(DateUtils.calculateAge(birthDate));
			filteredPerson.setEmail(peopleAndTheirMedicalRecordElement.getEmail());
			filteredPerson.setMedications(peopleAndTheirMedicalRecordElement.getMedications());
			filteredPerson.setAllergies(peopleAndTheirMedicalRecordElement.getAllergies());
			responseDTO.add(filteredPerson);
			}
		}
		
		
		return responseDTO;
	}
}
