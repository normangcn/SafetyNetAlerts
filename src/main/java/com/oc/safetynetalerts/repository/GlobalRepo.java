/**
 * 
 */
package com.oc.safetynetalerts.repository;

import java.util.ArrayList;
import java.util.List;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecords;
import com.oc.safetynetalerts.model.Person;

/**
 * @author gareth
 *
 */
public class GlobalRepo {
 public static List<MedicalRecord> medicalRecords = new ArrayList<>();
 public static List<Person> person = new ArrayList<>();
 public static List<FireStation> fireStation = new ArrayList<>();
 public static List<PeopleAndTheirMedicalRecords> peopleAndTheirMedicalRecords = new ArrayList<>();
 }

