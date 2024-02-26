/**
 * 
 */
package com.oc.safetynetalerts.service;


import com.oc.safetynetalerts.model.MedicalRecord;
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
	public static int countKids(MedicalRecord birthDate) {
		int kidsCount= 0;
		int personAge = 0;
		personAge = DateUtils.calculateAge(birthDate);//option 1
		if(personAge < 18) {
			kidsCount ++;
		}
		return kidsCount;
	}
	public static int countAdults(MedicalRecord birthDate) {
		int adultsCount= 0;
		int personAge = 0;
		personAge = countAge(birthDate);//option 2
		if(personAge > 18) {
			adultsCount ++;
		}
		return adultsCount;
	}
	public static int countAge(MedicalRecord birthDate) {
		int age = 0;
		age = DateUtils.calculateAge(birthDate);
		return age;
	}
}
