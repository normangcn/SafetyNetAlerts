/**
 * 
 */
package test.controller;


import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.person;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.repository.JsonReaderRepository;


/**
 * @author gareth
 *
 */
@SpringBootTest(classes= SafetyNetAlertsApplication.class )
@AutoConfigureMockMvc
public class ChildAlertControllerIT{
	@Autowired
    private MockMvc mockMvc;
	@BeforeEach
	public void setup() {
		JsonReaderRepository personRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository medicalRecordRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository fireStationRepoFromJson = new JsonReaderRepository();
		JsonReaderRepository peopleAndMedicalRecords = new JsonReaderRepository();
		try {
			medicalRecords = medicalRecordRepoFromJson.extractMedicalRecordsDataFromJsonNode();
			person = personRepoFromJson.extractPersonDataFromJsonNode();
			fireStation = fireStationRepoFromJson.extractFireStationsDataFromJsonNode();
			peopleAndtheirMedicalRecords = peopleAndMedicalRecords.combinePeopleAndMedicalRecords();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	@DisplayName("Should have Roger in the list of children for the address 1509 Culver St")
	 void listNameKidsForAddress_1509_Culver_St_givenAddress_1509_Culver_St_whenResultList_thenReturnCorrectResultList()throws Exception {
		
		this.mockMvc.perform(get("/childAlert/1509 Culver St")).andExpect(content().string(containsString("Roger")));
		
	}

}
