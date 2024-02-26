/**
 * 
 */
package com.oc.safetynetalerts.utils;

import java.time.LocalDate;
import java.time.Period;

import com.oc.safetynetalerts.model.MedicalRecord;

/**
 * @author gareth
 *
 */
public class DateUtils {
	public static int calculateAge(MedicalRecord birthDate) {
		LocalDate bithDateConverted = LocalDate.parse((CharSequence) birthDate);//CharSequence? Not String?
		LocalDate currentDate = LocalDate.now();
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(bithDateConverted, currentDate).getYears();
		} else {
			return 0;
		}
	}
}
