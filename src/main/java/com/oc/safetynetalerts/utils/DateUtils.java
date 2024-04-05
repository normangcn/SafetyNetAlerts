/**
 * 
 */
package com.oc.safetynetalerts.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
	public static LocalDate stringToLocalDateFormatter(String dateAsString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate formattedDateToLocalDate = LocalDate.parse(dateAsString, formatter);
		return formattedDateToLocalDate;		
	}
}
