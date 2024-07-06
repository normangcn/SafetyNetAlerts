package com.oc.safetynetalerts.controller;

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
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.service.FireStationService;

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
		FireStationService fireStationPeopleTreatment = new FireStationService();
		responseDTO = fireStationPeopleTreatment.fireStationStationNumberService(stationNumber);
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
	@ResponseStatus(HttpStatus.NO_CONTENT)
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
