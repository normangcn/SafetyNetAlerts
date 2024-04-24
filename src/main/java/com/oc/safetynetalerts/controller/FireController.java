/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.service.MedicalRecordService;

import DTOs.FirestationStationNumberOutDTO;
import DTOs.FirestationStationNumberPeople;
import DTOs.PersonToFirestationStationNumberPeopleImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/fire")
@RestController
@Slf4j
public class FireController {
	/*
	 * http://localhost:8080/fire?address=<address> Cette url doit retourner la
	 * liste des habitants vivant à l’adresse donnée ainsi que le numéro de la
	 * caserne de pompiers la desservant. La liste doit inclure le nom, le numéro de
	 * téléphone, l'âge et les antécédents médicaux (médicaments, posologie et
	 * allergies) de chaque personne.
	 */
	@GetMapping(value = "/{station_address}")
	@ResponseBody
	public FirestationStationNumberOutDTO fireStationStationAddress(@PathVariable("station_address") String address) {
		FirestationStationNumberOutDTO responseDTO = new FirestationStationNumberOutDTO();
		List<FireStation> allFireStations = fireStation;
		List<FireStation> filteredFireStations = new ArrayList<>();
		List<Person> allPeople = person;
		List<Person> filteredPeople = new ArrayList<>();
		List<MedicalRecord> allMedicalRecords = medicalRecords;
		List<MedicalRecord> filteredMedicalRecords = new ArrayList<>();
		Set<String> filteredMedicalRecordsDatesOnly = null;
		int kids = 0;
		int adults = 0;
		List<LocalDate> birthDatesOnly = null;

			for (FireStation stationElement : allFireStations) {
				if (stationElement.getStation().equals(String.valueOf(station))) {
					filteredFireStations.add(stationElement);
				}
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
		
		kids = MedicalRecordService.countKids(birthDatesOnly);//Adding kids and adults counter at end of endpoint result
		adults = MedicalRecordService.countAdults(birthDatesOnly);
		List<FirestationStationNumberPeople> personToFirestationStationNumberList = new ArrayList<>();
		
		personToFirestationStationNumberOutDTOMapper = new PersonToFirestationStationNumberPeopleImpl();
		personToFirestationStationNumberList = personToFirestationStationNumberOutDTOMapper.map(filteredPeople);
		responseDTO.setPeople(personToFirestationStationNumberList);
		responseDTO.setKidsCount(kids);
		responseDTO.setAdultsCount(adults);
		
		return responseDTO;
	}
		

}
