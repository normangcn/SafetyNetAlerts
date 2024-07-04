/**
 * 
 */
package com.oc.safetynetalerts.service;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.oc.safetynetalerts.DTOs.PersonInfoFirstNameAndLastNameOutDTO;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

/**
 * @author gareth
 *
 */
public class PersonInfoService {
	public  List<PersonInfoFirstNameAndLastNameOutDTO> personInfoService(String firstName, String lastName) {
		List<PersonInfoFirstNameAndLastNameOutDTO> responseDTO = new ArrayList<PersonInfoFirstNameAndLastNameOutDTO>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndtheirMedicalRecords = peopleAndtheirMedicalRecords;		
		LocalDate birthDate = null;
		
		for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElement: allPeopleAndtheirMedicalRecords) {
			if(peopleAndTheirMedicalRecordElement.getFirstName().equals(String.valueOf(firstName)) && peopleAndTheirMedicalRecordElement.getLastName().equals(String.valueOf(lastName))) {
				PersonInfoFirstNameAndLastNameOutDTO filteredPerson = new PersonInfoFirstNameAndLastNameOutDTO();
			filteredPerson.setFirstName(peopleAndTheirMedicalRecordElement.getFirstName());
			filteredPerson.setLastName(peopleAndTheirMedicalRecordElement.getLastName());
			filteredPerson.setAddress(peopleAndTheirMedicalRecordElement.getAddress());
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
