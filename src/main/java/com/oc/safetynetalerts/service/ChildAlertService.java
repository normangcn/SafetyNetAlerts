package com.oc.safetynetalerts.service;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.oc.safetynetalerts.DTOs.ChildAlertAddressOutDTO;
import com.oc.safetynetalerts.DTOs.FamilyMember;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;
/**
 * @author gareth
 *
 */
@Slf4j
public class ChildAlertService {
	public List<ChildAlertAddressOutDTO> childAlertAddressService(String address) {
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
