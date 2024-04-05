/**
 * 
 */
package com.oc.safetynetalerts.service;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.repository.JsonReaderRepository;
import com.oc.safetynetalerts.utils.DateUtils;
import com.oc.safetynetalerts.utils.StringUtils;

import lombok.extern.slf4j.Slf4j;


/**
 * @author gareth
 *
 */
@Slf4j
public class MedicalRecordService {
	
	public static int kidsCount = 0;
	public static int adultsCount = 0;
	private static List<LocalDate> birthDateListConvertedToLocalDate;

	public static List<MedicalRecord> fullNameCreationMedicalRecord() throws IOException {
		List<MedicalRecord> allMedicalRecords = new ArrayList<>();
		try {
			JsonReaderRepository repository = new JsonReaderRepository();
					allMedicalRecords = repository.extractMedicalRecordsDataFromJsonNode();
			for (MedicalRecord recordElement : allMedicalRecords) {
				String firstNameTemp = null;
				String lastNameTemp = null;
				firstNameTemp = recordElement.getFirstName();
				lastNameTemp = recordElement.getLastName();
				String nameConcated = StringUtils.concatNames(firstNameTemp, lastNameTemp);
				recordElement.setFullName(nameConcated);
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMedicalRecords;
	}
	public static List<LocalDate> convertBithdateStringToLocalDate(Set<String> filteredMedicalRecordsDatesOnly){
		birthDateListConvertedToLocalDate = null;
		for(String medicalRecordDateElement : filteredMedicalRecordsDatesOnly) {
			birthDateListConvertedToLocalDate.add(DateUtils.stringToLocalDateFormatter(medicalRecordDateElement));
		}
		return birthDateListConvertedToLocalDate;
	}
	public static int countKids(List<LocalDate> birthDatesOnly) {
		for (LocalDate dateElement : birthDatesOnly) {		
				LocalDate birthDate = dateElement;
				int personAge = 0;
				personAge = DateUtils.calculateAge(birthDate);				
				if(personAge <= 18) {
					kidsCount ++;
				}
	}
		return kidsCount;
	}
	public static int countAdults(List<LocalDate> birthDatesOnly) {
		for (LocalDate dateElement : birthDatesOnly) {		
			LocalDate birthDate = dateElement;
			int personAge = 0;
			personAge = DateUtils.calculateAge(birthDate);				
			if(personAge >= 18) {
				adultsCount ++;
			}
		
		}
	return adultsCount;
	}
}
