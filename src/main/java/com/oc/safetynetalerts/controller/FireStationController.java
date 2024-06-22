package com.oc.safetynetalerts.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.DTOs.FirestationStationNumberOutDTO;
import com.oc.safetynetalerts.DTOs.FirestationStationNumberPeople;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */
@RequestMapping("/firestation")
@RestController
@Slf4j
public class FireStationController {

	@GetMapping()
	@ResponseBody
	public FirestationStationNumberOutDTO fireStationStationNumber(@RequestParam String stationNumber) {
		FirestationStationNumberOutDTO responseDTO = new FirestationStationNumberOutDTO();
		List<FirestationStationNumberPeople> peopleAtAddresses = new ArrayList<>();
		List<FireStation> allFireStations = fireStations;
		List<FireStation> filteredFireStations = new ArrayList<>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndTheirmedicalrecords = peopleAndtheirMedicalRecords;		
		int kids = 0;
		int adults = 0;


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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String addFireStation(@RequestBody FireStation newFireStation) {
		fireStations.add(newFireStation);
		return "Station added as:" + newFireStation;
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public String updateFireStation(@RequestParam String address, @RequestBody FireStation updateFireStation) {
	
		for(FireStation fireStationElement:fireStations) {
	        if(fireStationElement.getAddress().equals(address)) {
	        	fireStationElement.setStation(updateFireStation.getStation());
	        }
	    }
		 return "Station at address " + address + " station id updated.";
	}

	@DeleteMapping()
	@ResponseStatus(HttpStatus.OK)
	public String deleteFireStation(@RequestParam String station, @RequestParam String address) {
		List<FireStation> deleteFireStations = new ArrayList<>();
		FireStation deleteFireStation = new FireStation();
		deleteFireStation.setAddress(address);
		deleteFireStation.setStation(station);
		deleteFireStations.add(deleteFireStation);
		fireStations.removeAll(deleteFireStations);
		return "Station at address " + address + " deleted.";
	}
}
