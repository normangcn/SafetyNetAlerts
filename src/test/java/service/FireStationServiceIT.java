/**
 * 
 */
package service;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStation;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.person;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * @author gareth
 *
 */
@SpringBootTest(classes= SafetyNetAlertsApplication.class )
@AutoConfigureMockMvc
public class FireStationServiceIT {
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
	@DisplayName("Should have 2 as station number and Eric Cadigan and the 3 Zemicks ")
	public void listNameCheckUTForStation2givenStationNumber2_whenResultList_thenReturnCorrectResultList() throws Exception {
		/*
		 * ArrayList<String> expectedList = new ArrayList<String>();
		 * expectedList.add("Sophia"); expectedList.add("Zemicks");
		 * expectedList.add("892 Downing Ct"); expectedList.add("841-874-7878");
		 * expectedList.add("kids: 1"); expectedList.add("adults: 2"); ArrayList<String>
		 * actualList = new ArrayList<String>();
		 */
		
		//mockMvc.perform(get("http://localhost:8080/firestation")).andExpect(status().isOk());
		ResultActions resultActions = mockMvc.perform(get("/firestation/2")).andExpect(content().string(containsString("Zemicks")));
		
	    System.out.println(resultActions);
		//Assert.assertEquals(expectedList, actualList); 
	}
		
}
