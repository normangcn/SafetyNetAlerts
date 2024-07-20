/**
 * 
 */
package com.oc.safetynetalerts.service;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.util.ArrayList;
import java.util.List;


import com.oc.safetynetalerts.DTOs.PhoneAlertFireStationOutDTO;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@Slf4j
public class PhoneAlertService {
	public  List<PhoneAlertFireStationOutDTO> phoneAlertService(String firestation) {
	List<PhoneAlertFireStationOutDTO> responseDTO = new ArrayList<PhoneAlertFireStationOutDTO>();
	List<PeopleAndTheirMedicalRecord> allPeopleAndTheirMedicalRecords = peopleAndtheirMedicalRecords;
	List<FireStation> allFireStations = fireStations;
	List<FireStation> filteredAddresses = new ArrayList<>();
	
	for(FireStation fireStationElement: allFireStations) {
		if(fireStationElement.getStation().equals(String.valueOf(firestation))) {
		FireStation filteredAddress = new FireStation();
		filteredAddress.setAddress(fireStationElement.getAddress());
		filteredAddresses.add(filteredAddress);
		}
	}
	for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordsElement: allPeopleAndTheirMedicalRecords) {
		PhoneAlertFireStationOutDTO phoneAlert = new PhoneAlertFireStationOutDTO();
		for(FireStation fireStationElement2 : filteredAddresses) {
		if(peopleAndTheirMedicalRecordsElement.getAddress().equals(String.valueOf(fireStationElement2.getAddress()))) {
			phoneAlert.setPhone(peopleAndTheirMedicalRecordsElement.getPhone());
			responseDTO.add(phoneAlert);
		}
	}
	}
	return responseDTO ;
}
}
