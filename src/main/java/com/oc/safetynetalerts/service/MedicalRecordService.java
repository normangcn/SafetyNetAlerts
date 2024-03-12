/**
 * 
 */
package com.oc.safetynetalerts.service;


import java.time.LocalDate;

import com.oc.safetynetalerts.utils.DateUtils;


/**
 * @author gareth
 *
 */
public class MedicalRecordService {
	/*
	 * public static LocalDate convertDateStringToLocalDate(MedicalRecord birthDate)
	 * { LocalDate bdToLocalDate= null; DateFormat DFormat =
	 * DateFormat.getDateInstance(); bdToLocalDate = DFormat.format(birthDate);
	 * return bdToLocalDate; }
	 */
	/*
	 * public static int calculateAge(MedicalRecord birthDate, LocalDate
	 * currentDate) { LocalDate bithDateConverted = LocalDate.parse((CharSequence)
	 * birthDate);//CharSequence? Not String? if ((birthDate != null) &&
	 * (currentDate != null)) { return Period.between(bithDateConverted,
	 * currentDate).getYears(); } else { return 0; } }
	 */
	
	public static int kidsCount = 0;
	public static int countKids(LocalDate birthDate) {
		int personAge = 0;
		personAge = DateUtils.calculateAge(birthDate);
		if(personAge <= 18) {
			kidsCount ++;
		}
		return kidsCount;
	}
	public static int countAdults(LocalDate birthDate) {
		int adultsCount= 0;
		int personAge = 0;
		personAge = DateUtils.calculateAge(birthDate);
		if(personAge > 18) {
			adultsCount ++;
		}
		return adultsCount;
	}
}
