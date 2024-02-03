/**
 * 
 */
package com.oc.safetynetalerts.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author gareth
 *
 */
public class DateUtils {
	public static int calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}
}
