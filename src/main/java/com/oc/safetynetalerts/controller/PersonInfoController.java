/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;

import DTOs.ChildAlertAddressOutDTO;
import DTOs.FamilyMember;
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
	@GetMapping(value = "/{first_name and last_name}")
	@ResponseBody
	public List<PersonInfoFirstNameAndLastNameOutDTO> personInfo(@RequestParam("first_name") String firstName @PathVariable("last_name")String lastName) {
		List<ChildAlertAddressOutDTO> responseDTO = new ArrayList<ChildAlertAddressOutDTO>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndtheirMedicalRecords = peopleAndtheirMedicalRecords;
		
		LocalDate birthDate = null;
		List<FamilyMember> kidsFamilyMembers = new ArrayList<>();
	}
}
