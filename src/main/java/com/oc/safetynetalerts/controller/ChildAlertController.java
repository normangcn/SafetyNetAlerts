/**
 * 
 */
package com.oc.safetynetalerts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DTOs.ChildAlertAddressOutDTO;
import DTOs.FamilyMember;
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
	public List<ChildAlertAddressOutDTO> childAlertAddress(@PathVariable("home_address") String address) {
		List<ChildAlertAddressOutDTO> responseDTO = new ArrayList<ChildAlertAddressOutDTO>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndtheirMedicalRecords = peopleAndtheirMedicalRecords;
		
		LocalDate birthDate = null;
		List<FamilyMember> kidsFamilyMembers = new ArrayList<>();
		
		
		
		for( PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElementAdults: allPeopleAndtheirMedicalRecords) {
			if(peopleAndTheirMedicalRecordElementAdults.getAddress().equals(String.valueOf(address))) {				
				PeopleAndTheirMedicalRecord filteredByAddressPeopleAndtheirMedicalRecord = new PeopleAndTheirMedicalRecord();
				filteredByAddressPeopleAndtheirMedicalRecord.setFullName(peopleAndTheirMedicalRecordElementAdults.getFullName());
				birthDate = DateUtils.stringToLocalDateFormatter(peopleAndTheirMedicalRecordElementAdults.getBirthdate());
				filteredByAddressPeopleAndtheirMedicalRecord.setAge(DateUtils.calculateAge(birthDate));
					if(DateUtils.validateAdult(filteredByAddressPeopleAndtheirMedicalRecord.getAge())) {
						FamilyMember kidFamilyMember = new FamilyMember();
						kidFamilyMember.setFullName(filteredByAddressPeopleAndtheirMedicalRecord.getFullName());
						kidsFamilyMembers.add(kidFamilyMember);										
					}				
			}
		}
		for( PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElementKids: allPeopleAndtheirMedicalRecords) {
			if(peopleAndTheirMedicalRecordElementKids.getAddress().equals(String.valueOf(address))) {				
				PeopleAndTheirMedicalRecord filteredByAddressPeopleAndtheirMedicalRecord = new PeopleAndTheirMedicalRecord();
				filteredByAddressPeopleAndtheirMedicalRecord.setFirstName(peopleAndTheirMedicalRecordElementKids.getFirstName());
				filteredByAddressPeopleAndtheirMedicalRecord.setLastName(peopleAndTheirMedicalRecordElementKids.getLastName());
				birthDate = DateUtils.stringToLocalDateFormatter(peopleAndTheirMedicalRecordElementKids.getBirthdate());
				filteredByAddressPeopleAndtheirMedicalRecord.setAge(DateUtils.calculateAge(birthDate));
					if(DateUtils.validateKids(filteredByAddressPeopleAndtheirMedicalRecord.getAge())) {
						ChildAlertAddressOutDTO kidAndItsMedicalRecord= new ChildAlertAddressOutDTO();
						kidAndItsMedicalRecord.setFirstName(filteredByAddressPeopleAndtheirMedicalRecord.getFirstName());
						kidAndItsMedicalRecord.setLastName(filteredByAddressPeopleAndtheirMedicalRecord.getLastName());
						kidAndItsMedicalRecord.setAge(filteredByAddressPeopleAndtheirMedicalRecord.getAge());
						kidAndItsMedicalRecord.setFamilyMembers(kidsFamilyMembers);
						responseDTO.add(kidAndItsMedicalRecord);			
					}					
			}
		}
		
		return responseDTO;	
	}

}
