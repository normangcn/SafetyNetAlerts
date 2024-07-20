/**
 * 
 */
package com.oc.safetynetalerts.service;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.oc.safetynetalerts.DTOs.FirestationStationNumberOutDTO;
import com.oc.safetynetalerts.DTOs.FirestationStationNumberPeople;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@Slf4j
public class FireStationService {
	
	FirestationStationNumberOutDTO responseDTO = new FirestationStationNumberOutDTO();
	List<FirestationStationNumberPeople> peopleAtAddresses = new ArrayList<>();
	List<FireStation> allFireStations = fireStations;
	List<FireStation> filteredFireStations = new ArrayList<>();
	List<PeopleAndTheirMedicalRecord> allPeopleAndTheirmedicalrecords = peopleAndtheirMedicalRecords;		
	int kids = 0;
	int adults = 0;

	public FirestationStationNumberOutDTO fireStationStationNumberService(String stationNumber) {
		for (FireStation stationElement : allFireStations) {
			if (stationElement.getStation().equals(String.valueOf(stationNumber))) {
				filteredFireStations.add(stationElement);
			}
		}
		
		for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElement : allPeopleAndTheirmedicalrecords) {
			FirestationStationNumberPeople peopleAtAddress = new FirestationStationNumberPeople();
			for(FireStation fireStationElement2 :filteredFireStations)
			if(peopleAndTheirMedicalRecordElement.getAddress().equals(String.valueOf(fireStationElement2.getAddress()))) {
				peopleAtAddress.setFirstName(peopleAndTheirMedicalRecordElement.getFirstName());
				peopleAtAddress.setLastName(peopleAndTheirMedicalRecordElement.getLastName());
				peopleAtAddress.setAddress(peopleAndTheirMedicalRecordElement.getAddress());
				peopleAtAddress.setPhone(peopleAndTheirMedicalRecordElement.getPhone());
				peopleAtAddresses.add(peopleAtAddress);
				LocalDate birthdate = DateUtils.stringToLocalDateFormatter(peopleAndTheirMedicalRecordElement.getBirthdate());
				int age = DateUtils.calculateAge(birthdate);
				if(DateUtils.validateKids(age)) {
					kids++;
				}
				else {
					adults++;
				}
			}
		}
	
	responseDTO.setPeople(peopleAtAddresses);
	responseDTO.setKids(kids);
	responseDTO.setAdults(adults);
	
	return responseDTO;
	}
}
