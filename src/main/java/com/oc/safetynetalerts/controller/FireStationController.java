/**
 * 
 */
package com.oc.safetynetalerts.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */
@RequestMapping("/firestation")
@RestController
@Slf4j
public class FireStationController {
	JsonReaderRepository repository = new JsonReaderRepository();
    @GetMapping("/test")
    public String test() {
	String test = "test";
	return test;
    }
    
    @GetMapping(value= "/{station_number}")
    @ResponseBody
    public List<FireStation> fireStationStationNumber(@PathVariable("station_number") int station) {
    	List<FireStation> allFireStations = null;
    	List<FireStation> filteredFireStations = new ArrayList<>();
		/*
		 * List<Person> allPeople = null; List<Person> filteredPeople = new
		 * ArrayList<>(); List<MedicalRecord> allMedicalRecords = null;
		 * List<MedicalRecord> filteredMedicalRecords = new ArrayList<>(); List<String>
		 * resultForFireStationNumber = new ArrayList<>();
		 */
	try {
		
		  allFireStations = repository.extractFireStationsDataFromJsonNode(); 
			/*
			 * allPeople = repository.extractPersonDataFromJsonNode(); allMedicalRecords =
			 * repository.extractMedicalRecordsDataFromJsonNode();
			 */
		 
		for(FireStation stationElement:allFireStations) {
			if(stationElement.getStation().equals(String.valueOf(station))) {
				filteredFireStations.add(stationElement);
			}
		}
	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	filteredPeople = allPeople.stream().filter(item -> filteredFireStation.contains(item.address)).collect(Collectors.toList());
	return filteredFireStations;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addFireStation(@RequestBody FireStation newFireStation) {
	return "Station added as:" + newFireStation;
    }
    
    @PutMapping(value= "/{station_number}")
    @ResponseStatus(HttpStatus.OK)
    public String updateFireStation(@PathVariable int station_number, @RequestBody FireStation updateFireStation) {
	return "Station "+ station_number + " information updated.";
    }
    @DeleteMapping(value = "/{station_number}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFireStation(@PathVariable("station_number") int station) {
    }
}
