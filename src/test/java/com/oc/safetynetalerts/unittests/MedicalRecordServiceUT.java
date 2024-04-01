/**
 * 
 */
package com.oc.safetynetalerts.unittests;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;//import this. Not the basic Junit import as it prevents @DisplayName from working
import org.junit.jupiter.api.DisplayName;

import com.oc.safetynetalerts.service.MedicalRecordService;

/**
 * @author gareth
 *
 */
@DisplayName("Unit tests for MedicalRecordService")
public class MedicalRecordServiceUT {
	@Test
	@DisplayName("Should count kids")
	public void countKidsUTgivenBirthDateOfMinor_whenCalculateAge_thenReturnAdd1Kid() {
		LocalDate birthDate = LocalDate.of(2024, 1, 1);
		int actualKidsCount = MedicalRecordService.countKids(birthDate);
	    int expectedKidsCount = 1;
	    Assert.assertEquals(expectedKidsCount, actualKidsCount); 
	}
	@Test
	@DisplayName("Should count adults")
	public void countAdultsUTgivenBirthDateOfMinor_whenCalculateAge_thenReturnAdd1Adult() {//a re-nomer
		LocalDate birthDate = LocalDate.of(1983, 1, 1);
		int actualAdultCount = MedicalRecordService.countAdults(birthDate);
		int expectedAdultCount = 1;
		Assert.assertEquals(expectedAdultCount, actualAdultCount);
	}
	
		
}
