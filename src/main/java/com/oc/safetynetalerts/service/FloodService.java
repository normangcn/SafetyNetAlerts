/**
 * 
 */
package com.oc.safetynetalerts.service;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.oc.safetynetalerts.DTOs.FloodStationsStationsOutDTO;
import com.oc.safetynetalerts.DTOs.Residents;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@Slf4j
public class FloodService {
	public List<FloodStationsStationsOutDTO> floodStationService(List<String> stations){
		List<FloodStationsStationsOutDTO> responseDTO = new ArrayList<FloodStationsStationsOutDTO>();
		List<FireStation> allFireStations = fireStations;
		List<PeopleAndTheirMedicalRecord> allPeopleAndTheirMedicalrecords = peopleAndtheirMedicalRecords;
		List<FireStation> fireStationAddresses = new ArrayList<>();
		for(FireStation fireStationElement : allFireStations) {
			for(String stationElement:stations) {				
			if(fireStationElement.getStation().equals(String.valueOf(stationElement))) {
				FireStation fireStationAddress = new FireStation();
				fireStationAddress.setAddress(fireStationElement.getAddress());
				fireStationAddresses.add(fireStationAddress);
			}
		}
		}
			for(FireStation fireStationElementSecondLoop : fireStationAddresses) {
				FloodStationsStationsOutDTO floodStationsStation = new FloodStationsStationsOutDTO();
				List<Residents> residents = new ArrayList<>();
				floodStationsStation.setAddress(fireStationElementSecondLoop.getAddress());
				for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElement : allPeopleAndTheirMedicalrecords) {
					
				if(peopleAndTheirMedicalRecordElement.getAddress().equals(String.valueOf(fireStationElementSecondLoop.getAddress()))) {	
					LocalDate birthDate;
					Residents resident = new Residents();
					resident.setFullName(peopleAndTheirMedicalRecordElement.getFullName());
					resident.setPhoneNumber(peopleAndTheirMedicalRecordElement.getPhone());
					birthDate = DateUtils.stringToLocalDateFormatter(peopleAndTheirMedicalRecordElement.getBirthdate());				
					resident.setAge(DateUtils.calculateAge(birthDate));
					resident.setMedications(peopleAndTheirMedicalRecordElement.getMedications());
					resident.setAllergies(peopleAndTheirMedicalRecordElement.getAllergies());
					residents.add(resident);
				}	
				floodStationsStation.setResidents(residents);
			}
				responseDTO.add(floodStationsStation);
			}
		
		return responseDTO;
}
	
}
