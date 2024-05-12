/**
 * 
 */
package com.oc.safetynetalerts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import DTOs.FloodStationsStationsOutDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/flood")
@RestController
@Slf4j
public class FloodController {
	/*
	 * http://localhost:8080/flood/stations?stations=<a list of station_numbers>
	 * Cette url doit retourner une liste de tous les foyers desservis par la
	 * caserne. Cette liste doit regrouper les personnes par adresse. Elle doit
	 * aussi inclure le nom, le numéro de téléphone et l'âge des habitants, et faire
	 * figurer leurs antécédents médicaux (médicaments, posologie et allergies) à
	 * côté de chaque nom.
	 */
	
	@GetMapping("/stations")
	@ResponseBody
	public List<FloodStationsStationsOutDTO> floodStation(@RequestParam List<String> station){
		List<FloodStationsStationsOutDTO> responseDTO = new ArrayList<FloodStationsStationsOutDTO>();
		List<FireStation> allFireStations = fireStation;
		List<PeopleAndTheirMedicalRecord> allPeopleAndTheirMedicalrecords = peopleAndtheirMedicalRecords;
		List<FireStation> fireStationAddresses = new ArrayList<>();
		for(FireStation fireStationElement : allFireStations) {
			if(fireStationElement.getStation().equals(String.valueOf(station))) {
				FireStation fireStationAddress = new FireStation();
				fireStationAddress.setAddress(fireStationElement.getAddress());
				fireStationAddresses.add(fireStationAddress);
			}
		}
		
			for(FireStation fireStationElementSecondLoop : fireStationAddresses) {
				FloodStationsStationsOutDTO floodStationsStation = new FloodStationsStationsOutDTO();
				floodStationsStation.setAddress(fireStationElementSecondLoop.getAddress());
				for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElement : allPeopleAndTheirMedicalrecords)
				if(peopleAndTheirMedicalRecordElement.getAddress().equals(String.valueOf(fireStationElementSecondLoop.getAddress()))) {
					
				
				}
			}
		
		
		return responseDTO;
	}
}
