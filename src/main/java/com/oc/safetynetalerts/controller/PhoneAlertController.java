/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;

import DTOs.PhoneAlertFireStationOutDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/phoneAlert")
@RestController
@Slf4j
public class PhoneAlertController {

	@GetMapping(value = "/{firestation_number}")
	@ResponseBody
	public  List<PhoneAlertFireStationOutDTO> phoneAlert(@PathVariable("firestation_number") String stationNumber) {
		List<PhoneAlertFireStationOutDTO> responseDTO = new ArrayList<PhoneAlertFireStationOutDTO>();
		List<PeopleAndTheirMedicalRecord> allPeopleAndTheirMedicalRecords = peopleAndtheirMedicalRecords;
		List<FireStation> allFireStations = fireStation;
		List<FireStation> filteredAddresses = new ArrayList<>();
		
		for(FireStation fireStationElement: allFireStations) {
			if(fireStationElement.getStation().equals(String.valueOf(stationNumber))) {
			FireStation filteredAddress = new FireStation();
			filteredAddress.setAddress(fireStationElement.getAddress());
			filteredAddresses.add(filteredAddress);
			}
		}
		for(PeopleAndTheirMedicalRecord peopleAndTheirMedicalRecordsElement: allPeopleAndTheirMedicalRecords) {
			PhoneAlertFireStationOutDTO phoneAlert = new PhoneAlertFireStationOutDTO();
			for(FireStation fireStationElement2 : filteredAddresses) {
			if(peopleAndTheirMedicalRecordsElement.getAddress().equals(String.valueOf(fireStationElement2.getAddress()))) {
				phoneAlert.setPhone(peopleAndTheirMedicalRecordsElement.getPhone());
				responseDTO.add(phoneAlert);
			}
		}
		}
		return responseDTO ;
		
	}
}
