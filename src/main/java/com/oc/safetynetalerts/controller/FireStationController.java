package com.oc.safetynetalerts.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import com.oc.safetynetalerts.service.MedicalRecordService;
import com.oc.safetynetalerts.service.PersonService;

import DTOs.FirestationStationNumberOutDTO;
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

	
	/*
	 * public List<String> fireStationStationNumber(@PathVariable("station_number")
	 * int station) { List<FireStation> allFireStations = null; List<FireStation>
	 * filteredFireStations = new ArrayList<>(); List<Person> allPeople = null;
	 * List<Person> filteredPeople = new ArrayList<>(); List<MedicalRecord>
	 * allMedicalRecords = null; List<MedicalRecord> filteredMedicalRecords = new
	 * ArrayList<>(); Set<String> filteredMedicalRecordsDatesOnly = null; int kids =
	 * 0; int adults = 0; List<LocalDate> birthDatesOnly = null;
	 * List<String>resultForFireStationNumber = new ArrayList<>();
	 * 
	 * 
	 * try {
	 * 
	 * allFireStations = repository.extractFireStationsDataFromJsonNode(); allPeople
	 * = PersonService.fullNameCreationPerson(); allMedicalRecords =
	 * repository.extractMedicalRecordsDataFromJsonNode(); allMedicalRecords =
	 * MedicalRecordService.fullNameCreationMedicalRecord();
	 * 
	 * for (FireStation stationElement : allFireStations) { if
	 * (stationElement.getStation().equals(String.valueOf(station))) {
	 * filteredFireStations.add(stationElement); } } } catch (JsonParseException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (JsonMappingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } Set<String> fireStationsAddressesOnly =
	 * filteredFireStations.stream().map(FireStation::getAddress)
	 * .collect(Collectors.toSet()); filteredPeople = allPeople.stream().filter(e ->
	 * fireStationsAddressesOnly.contains(e.getAddress()))
	 * .collect(Collectors.toList()); Set<String> peopleFullNames =
	 * filteredPeople.stream().map(Person::getFullName)
	 * .collect(Collectors.toSet()); filteredMedicalRecords =
	 * allMedicalRecords.stream().filter(e ->
	 * peopleFullNames.contains(e.getFullName())) .collect(Collectors.toList());
	 * filteredMedicalRecordsDatesOnly =
	 * filteredMedicalRecords.stream().map(MedicalRecord::getBirthdate).collect(
	 * Collectors.toSet()); birthDatesOnly =
	 * MedicalRecordService.convertBithdateStringToLocalDate(
	 * filteredMedicalRecordsDatesOnly); kids =
	 * MedicalRecordService.countKids(birthDatesOnly); adults =
	 * MedicalRecordService.countAdults(birthDatesOnly); String
	 * resultForFireStationNumberAsString = filteredPeople.toString();
	 * resultForFireStationNumberAsString += " Kids: " + kids + " Adults: " +
	 * adults; System.out.println(resultForFireStationNumberAsString);
	 * resultForFireStationNumber.add(resultForFireStationNumberAsString); return
	 * resultForFireStationNumber; }
	 */
	@GetMapping(value = "/{station_number}")
	@ResponseBody
	public FirestationStationNumberOutDTO fireStationStationNumber2(@PathVariable("station_number") int station) {
		FirestationStationNumberOutDTO responseDTO = new FirestationStationNumberOutDTO();
		List<FireStation> allFireStations = null;
		List<FireStation> filteredFireStations = new ArrayList<>();
		List<Person> allPeople = null;
		List<Person> filteredPeople = new ArrayList<>();
		List<MedicalRecord> allMedicalRecords = null;
		List<MedicalRecord> filteredMedicalRecords = new ArrayList<>();
		Set<String> filteredMedicalRecordsDatesOnly = null;
		int kids = 0;
		int adults = 0;
		List<LocalDate> birthDatesOnly = null;
		

		try {

			allFireStations = repository.extractFireStationsDataFromJsonNode();
			allPeople = PersonService.fullNameCreationPerson();
			allMedicalRecords = repository.extractMedicalRecordsDataFromJsonNode();
			allMedicalRecords = MedicalRecordService.fullNameCreationMedicalRecord();

			for (FireStation stationElement : allFireStations) {
				if (stationElement.getStation().equals(String.valueOf(station))) {
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
		
		Set<String> fireStationsAddressesOnly = filteredFireStations.stream().map(FireStation::getAddress)
				.collect(Collectors.toSet());
		filteredPeople = allPeople.stream().filter(e -> fireStationsAddressesOnly.contains(e.getAddress()))
				.collect(Collectors.toList());
		Set<String> peopleFullNames = filteredPeople.stream().map(Person::getFullName)
				.collect(Collectors.toSet());
		filteredMedicalRecords = allMedicalRecords.stream().filter(e -> peopleFullNames.contains(e.getFullName()))
				.collect(Collectors.toList());
		
		filteredMedicalRecordsDatesOnly = filteredMedicalRecords.stream().map(MedicalRecord::getBirthdate).collect(Collectors.toSet());
		birthDatesOnly = MedicalRecordService.convertBithdateStringToLocalDate(filteredMedicalRecordsDatesOnly);
		
		kids = MedicalRecordService.countKids(birthDatesOnly);//Adding kids and adults counter at end of endpoint
		adults = MedicalRecordService.countAdults(birthDatesOnly);
		responseDTO.setPeople(filteredPeople);
		responseDTO.setKidsCount(kids);
		responseDTO.setAdultsCount(adults);
		
		return responseDTO;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String addFireStation(@RequestBody FireStation newFireStation) {
		return "Station added as:" + newFireStation;
	}

	@PutMapping(value = "/{station_number}")
	@ResponseStatus(HttpStatus.OK)
	public String updateFireStation(@PathVariable int station_number, @RequestBody FireStation updateFireStation) {
		return "Station " + station_number + " information updated.";
	}

	@DeleteMapping(value = "/{station_number}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteFireStation(@PathVariable("station_number") int station) {
	}
}
