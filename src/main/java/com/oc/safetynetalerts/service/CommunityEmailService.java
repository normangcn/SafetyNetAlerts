/**
 * 
 */
package com.oc.safetynetalerts.service;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.util.ArrayList;
import java.util.List;


import com.oc.safetynetalerts.DTOs.CommunityEmailCityOutDTO;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@Slf4j
public class CommunityEmailService {
	public List<CommunityEmailCityOutDTO> communityEmailService(String city){
		List<CommunityEmailCityOutDTO> responseDTO = new ArrayList<CommunityEmailCityOutDTO>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndTheirMedicalRecords = peopleAndtheirMedicalRecords;
		
		for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordsElement: allPeopleAndTheirMedicalRecords) {
			if(peopleAndTheirMedicalRecordsElement.getCity().equals(String.valueOf(city))) {
				CommunityEmailCityOutDTO peopleEmail = new CommunityEmailCityOutDTO();
				peopleEmail.setEmail(peopleAndTheirMedicalRecordsElement.getEmail());
				responseDTO.add(peopleEmail);
			}
		}
		return responseDTO;
}
}
