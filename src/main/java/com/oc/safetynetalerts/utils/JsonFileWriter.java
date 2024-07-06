/**
 * 
 */
package com.oc.safetynetalerts.utils;
import static com.oc.safetynetalerts.repository.GlobalRepo.persons;
import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;

import java.io.FileWriter;

/**
 * @author gareth
 *
 */
public class JsonFileWriter {
	
	public void jsonFileWriter(){
		
    try (FileWriter fileWriter = new FileWriter("src/main/resources/data2.json")) {
        fileWriter.write(persons.toString());
        fileWriter.write(fireStations.toString());
        fileWriter.write(medicalRecords.toString());
        fileWriter.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
