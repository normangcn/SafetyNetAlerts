/**
 * 
 */
package test.service;

import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.persons;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

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
			persons = personRepoFromJson.extractPersonDataFromJsonNode();
			fireStations = fireStationRepoFromJson.extractFireStationsDataFromJsonNode();
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
	void listNameCheckUTForStation2givenStationNumber2_whenResultList_thenReturnCorrectResultList() throws Exception {	
		this.mockMvc.perform(get("/firestation?stationNumber=2"))
		.andExpect(content().string(containsString("Zemicks")))
		.andExpect(status().isOk());
		
	}
		
}
