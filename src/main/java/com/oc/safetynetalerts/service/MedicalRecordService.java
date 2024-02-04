/**
 * 
 */
package com.oc.safetynetalerts.service;

import java.time.LocalDate;
import java.time.Period;


/**
 * @author gareth
 *
 */
public class MedicalRecordService {
	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}
}