/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.person;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;

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
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;
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
	/*
	 * http://localhost:8080/fire?address=<address> Cette url doit retourner la
	 * liste des habitants vivant à l’adresse donnée ainsi que le numéro de la
	 * caserne de pompiers la desservant. La liste doit inclure le nom, le numéro de
	 * téléphone, l'âge et les antécédents médicaux (médicaments, posologie et
	 * allergies) de chaque personne.
	 */
	@GetMapping(value = "/{station_address}")
	@ResponseBody
	public FireAddressOutDTO fireStationStationAddress(@PathVariable("station_address") String address) {
		FireAddressOutDTO responseDTO = new FireAddressOutDTO();
		List<FireStation> allFireStations = fireStation;
		List<FireStation> filteredFireStations = new ArrayList<>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndTheirMedicalrecords = peopleAndtheirMedicalRecords;
		List<PeopleAndTheirMedicalRecord> filteredPeopleAndTheirMedicalrecords = new ArrayList<>();
		

		return responseDTO;
	}
		

}
