/**
 * 
 */
package test.utils;


import static com.oc.safetynetalerts.repository.GlobalRepo.fireStations;
import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.peopleAndtheirMedicalRecords;
import static com.oc.safetynetalerts.repository.GlobalRepo.persons;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.DTOs.JsonOutputDTO;
import com.oc.safetynetalerts.repository.GlobalRepo;
import com.oc.safetynetalerts.repository.JsonReaderRepository;
import com.oc.safetynetalerts.service.ObjectMapperService;
import com.oc.safetynetalerts.utils.JsonFileWriter;

/**
 * @author gareth
 *
 */
@SpringBootTest(classes= SafetyNetAlertsApplication.class )
public class JsonFileWriterTest {
    private JsonFileWriter jsonFileWriter;

    @BeforeEach
    public void setUp() {
    	
        jsonFileWriter = new JsonFileWriter();
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
    public void testJsonFileWriter() {
        JsonOutputDTO expectedOutput = new JsonOutputDTO();
        expectedOutput.setPersons(GlobalRepo.persons);
        expectedOutput.setFirestations(GlobalRepo.fireStations);
        expectedOutput.setMedicalrecords(GlobalRepo.medicalRecords);
        
        jsonFileWriter.jsonFileWriter();

        String jsonOutput = "";
        try {
            jsonOutput = new String(Files.readAllBytes(Paths.get("src/main/resources/data.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = ObjectMapperService.getInstance();
        String expectedJson = "";
        try {
            expectedJson = mapper.writeValueAsString(expectedOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedJson, jsonOutput);
    }
}
