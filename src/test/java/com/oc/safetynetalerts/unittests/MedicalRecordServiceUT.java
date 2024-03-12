/**
 * 
 */
package com.oc.safetynetalerts.unittests;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.oc.safetynetalerts.service.MedicalRecordService;

/**
 * @author gareth
 *
 */
@SpringBootTest
public class MedicalRecordServiceUT {
	@Test
	public void countKidsUT() {
		LocalDate birthDate = LocalDate.of(2024, 1, 1);
		int actualKidsCount = MedicalRecordService.countKids(birthDate);
	    int expectedKidsCount = 1;
	    Assert.assertEquals(expectedKidsCount, actualKidsCount); 
	}
	@Test
	public void countAdultsUT() {
		LocalDate birthDate = LocalDate.of(1983, 1, 1);
		int actualAdultCount = MedicalRecordService.countAdults(birthDate);
		int expectedAdultCount = 1;
		Assert.assertEquals(expectedAdultCount, actualAdultCount);
	}
		
}
