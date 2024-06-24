/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.DTOs.FireAddressOutDTO;
import com.oc.safetynetalerts.DTOs.MedicationAndAllergiesOnly;
import com.oc.safetynetalerts.DTOs.PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
import com.oc.safetynetalerts.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/fire")
@RestController
@Slf4j
public class FireController {

	@GetMapping()
	@ResponseBody
	public FireAddressOutDTO fireStationStationAddress(@RequestParam String address) {
		FireAddressOutDTO responseDTO = new FireAddressOutDTO();
		List<FireStation> allFireStations = fireStations;
		List<FireStation> filteredFireStations = new ArrayList<>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndTheirMedicalrecords = peopleAndtheirMedicalRecords;
		List<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies> filteredPeopleAndTheirMedicalrecords = new ArrayList<PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies>();
		
		for(FireStation fireStationElement : allFireStations) {
			if(fireStationElement.getAddress().equals(String.valueOf(address))) {
				FireStation filteredFireStation = new FireStation();
				filteredFireStation.setAddress(fireStationElement.getAddress());
				filteredFireStation.setStation(fireStationElement.getStation());
				filteredFireStations.add(filteredFireStation);

				responseDTO.setStationNumber(filteredFireStation.getStation());
			}
		}
		for(FireStation fireStationElement2 : allFireStations) {
		for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordElement: allPeopleAndTheirMedicalrecords) {
			if(peopleAndTheirMedicalRecordElement.getAddress().equals(String.valueOf(fireStationElement2.getAddress()))) {
				PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies filteredPeopleAndTheirMedicalRecord = new PeopleAtFireStationAdressWithAgeAndMedicationPlusAllergies();
				filteredPeopleAndTheirMedicalRecord.setFullName(peopleAndTheirMedicalRecordElement.getFullName());
				filteredPeopleAndTheirMedicalRecord.setPhone(peopleAndTheirMedicalRecordElement.getPhone());
				filteredPeopleAndTheirMedicalRecord.setAge(DateUtils.calculateAge(DateUtils.stringToLocalDateFormatter(peopleAndTheirMedicalRecordElement.getBirthdate())));
				List<MedicationAndAllergiesOnly> medicationAndAllergies = new ArrayList<>();
				MedicationAndAllergiesOnly medicationAndAllergy = new MedicationAndAllergiesOnly();
				medicationAndAllergy.setMedications(peopleAndTheirMedicalRecordElement.getMedications());
				medicationAndAllergy.setAllergies(peopleAndTheirMedicalRecordElement.getAllergies());
				medicationAndAllergies.add(medicationAndAllergy);
				filteredPeopleAndTheirMedicalRecord.setMedicationAndAllergies(medicationAndAllergies);
				filteredPeopleAndTheirMedicalrecords.add(filteredPeopleAndTheirMedicalRecord);	
			}
		}
		}
		responseDTO.setPeople(filteredPeopleAndTheirMedicalrecords);
		
		return responseDTO;
	}
		

}
