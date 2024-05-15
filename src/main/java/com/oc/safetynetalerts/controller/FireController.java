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
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.utils.DateUtils;
import com.oc.safetynetalerts.utils.StringUtils;

import DTOs.FireAddressOutDTO;
import DTOs.MedicationAndAllergiesOnly;
import DTOs.PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/fire")
@RestController
@Slf4j
public class FireController {

	@GetMapping(value = "/{station_address}")
	@ResponseBody
	public FireAddressOutDTO fireStationStationAddress(@PathVariable("station_address") String address) {
		FireAddressOutDTO responseDTO = new FireAddressOutDTO();
		List<FireStation> allFireStations = fireStation;
		List<FireStation> filteredFireStations = new ArrayList<>();
		List<Person> allPeople = person;
		List<Person> filteredPeople = new ArrayList<>();
		List<MedicalRecord> allMedicalRecords = medicalRecords;
		
			for (FireStation stationElement : allFireStations) {
				if (stationElement.getAddress().equals(String.valueOf(address))) {
					filteredFireStations.add(stationElement);
					responseDTO.setStationNumber(stationElement.getStation());//Setting the station number for the reply
					for(FireStation filteredFireStationsElement : filteredFireStations) {//Loop by firestation number
						if(filteredFireStationsElement.getStation().equals(String.valueOf(responseDTO.getStationNumber()))) {
							String fireStationsAddressesOnly = filteredFireStationsElement.getAddress();					
							filteredPeople = allPeople.stream().filter(e -> fireStationsAddressesOnly.contains(e.getAddress()))
									.collect(Collectors.toList());//Matching people to their firestation's address
							List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> peopleAtAdresss = new ArrayList<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies>();
							for(Person personElement : filteredPeople) {
								PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies peopleByStationListFeeder = new PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies();		
								peopleByStationListFeeder.setFullName(StringUtils.concatNames(personElement.getFirstName(), personElement.getLastName()));
								peopleByStationListFeeder.setPhone(personElement.getPhone());							
								
								MedicalRecord medicalRecordForPeopleByStation = new MedicalRecord();
								int age = 0;
								for(MedicalRecord medicalRecordElement : allMedicalRecords) {
									medicalRecordForPeopleByStation.setFullName(StringUtils.concatNames(medicalRecordElement.getFirstName(), medicalRecordElement.getLastName()));
									medicalRecordForPeopleByStation.setBirthdate(medicalRecordElement.getBirthdate());
									medicalRecordForPeopleByStation.setAllergies(medicalRecordElement.getAllergies());
									medicalRecordForPeopleByStation.setMedications(medicalRecordElement.getMedications());
									if(medicalRecordForPeopleByStation.getFullName().equals(String.valueOf(peopleByStationListFeeder.getFullName()))){
										List<MedicationAndAllergiesOnly> medicationAndAllergiesOnlys = new ArrayList<>();
										MedicationAndAllergiesOnly medicationAndAllergiesOnly = new MedicationAndAllergiesOnly();		
										medicationAndAllergiesOnly.setMedications(medicalRecordForPeopleByStation.getMedications());
										medicationAndAllergiesOnly.setAllergies(medicalRecordForPeopleByStation.getAllergies());
										medicationAndAllergiesOnlys.add(medicationAndAllergiesOnly);//add alergies and medication to medication list
										LocalDate dateForAgeCalculation = DateUtils.stringToLocalDateFormatter(medicalRecordElement.getBirthdate());
										age = DateUtils.calculateAge(dateForAgeCalculation);
										peopleByStationListFeeder.setMedicationAndAllergies(medicationAndAllergiesOnlys);
									}				
								}
								peopleByStationListFeeder.setAge(age);
								peopleAtAdresss.add(peopleByStationListFeeder);//add people's full name and phone number to the list of people
							}
							responseDTO.setPeople(peopleAtAdresss);											
						}
					}
				}
			}
		return responseDTO;
	}
		

}
