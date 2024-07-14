package test.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.medicalRecords;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.controller.MedicalRecordController;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.repository.JsonReaderRepository;
import com.oc.safetynetalerts.utils.JsonFileWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SafetyNetAlertsApplication.class)
public class MedicalRecordControllerTest {

    @Autowired
    private TestRestTemplate template;

    @MockBean
    private JsonFileWriter jsonFileWriter;

    @InjectMocks
    private MedicalRecordController medicalRecordController;
    private AutoCloseable closeable;
    private List<MedicalRecord> originalMedicalRecords;

    @BeforeEach
    public void setUp() {
        JsonReaderRepository medicalRecordRepoFromJson = new JsonReaderRepository();
        try {
            medicalRecords = medicalRecordRepoFromJson.extractMedicalRecordsDataFromJsonNode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeable = MockitoAnnotations.openMocks(this);
        originalMedicalRecords = new ArrayList<>(medicalRecords);
        doNothing().when(jsonFileWriter).jsonFileWriter();
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
        medicalRecords.clear();
        medicalRecords.addAll(originalMedicalRecords);
    }

    @Test
    void contextLoads() throws Exception {
        assertThat(template).isNotNull();
    }

    @Test
    public void addMedicalRecord_ShouldReturnCreated() {
        MedicalRecord newMedicalRecord = new MedicalRecord("John", "Doe", "01/01/2000", List.of("med1"), List.of("allergy1"));
        ResponseEntity<String> response = template.postForEntity("/medicalrecord", newMedicalRecord, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void updateMedicalRecord_ShouldReturnOk() {
        MedicalRecord updateMedicalRecord = new MedicalRecord("John", "Doe", "02/02/2000", List.of("med2"), List.of("allergy2"));

        String url = "/medicalrecord?firstName=John&lastName=Doe";
        ResponseEntity<String> response = template.exchange(url, HttpMethod.PUT, new HttpEntity<>(updateMedicalRecord), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteMedicalRecord_ShouldReturnOk() {
        String url = "/medicalrecord?firstName=John&lastName=Doe";
        ResponseEntity<String> response = template.exchange(url, HttpMethod.DELETE, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
