/**
 * 
 */
package test.model;

/**
 * @author gareth
 *
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.model.MedicalRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@SpringBootTest(classes= SafetyNetAlertsApplication.class )
public class MedicalRecordTest {

    private MedicalRecord medicalRecord;

    @BeforeEach
    public void setUp() {
        medicalRecord = new MedicalRecord();
    }

    @Test
    public void testGettersAndSetters() {
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        UUID id = UUID.randomUUID();

        medicalRecord.setId(id);
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Doe");
        medicalRecord.setBirthdate("01/01/2000");
        medicalRecord.setMedications(medications);
        medicalRecord.setAllergies(allergies);

        assertEquals(id, medicalRecord.getId());
        assertEquals("John", medicalRecord.getFirstName());
        assertEquals("Doe", medicalRecord.getLastName());
        assertEquals("01/01/2000", medicalRecord.getBirthdate());
        assertEquals(medications, medicalRecord.getMedications());
        assertEquals(allergies, medicalRecord.getAllergies());
    }

    @Test
    public void testWithMethods() {
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();

        medicalRecord.withFirstName("John")
                     .withLastName("Doe")
                     .withBirthdate("01/01/2000")
                     .withMedications(medications)
                     .withAllergies(allergies);

        assertEquals("John", medicalRecord.getFirstName());
        assertEquals("Doe", medicalRecord.getLastName());
        assertEquals("01/01/2000", medicalRecord.getBirthdate());
        assertEquals(medications, medicalRecord.getMedications());
        assertEquals(allergies, medicalRecord.getAllergies());
    }

    @Test
    public void testAdditionalProperties() {
        String key = "key1";
        String value = "value1";

        medicalRecord.setAdditionalProperty(key, value);
        Map<String, Object> expectedProperties = new HashMap<>();
        expectedProperties.put(key, value);

        assertEquals(expectedProperties, medicalRecord.getAdditionalProperties());
    }

    @Test
    public void testEqualsAndHashCode() {
        MedicalRecord obj1 = new MedicalRecord("John", "Doe", "01/01/2000", new ArrayList<>(), new ArrayList<>());
        MedicalRecord obj2 = new MedicalRecord("John", "Doe", "01/01/2000", new ArrayList<>(), new ArrayList<>());

        assertEquals(obj1, obj2);
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    public void testToString() {
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Doe");
        medicalRecord.setBirthdate("01/01/2000");
        medicalRecord.setMedications(new ArrayList<>());
        medicalRecord.setAllergies(new ArrayList<>());

       

        assertTrue(medicalRecord.toString().startsWith("com.oc.safetynetalerts.model.MedicalRecord@"));
        assertTrue(medicalRecord.toString().contains("firstName=John"));
        assertTrue(medicalRecord.toString().contains("lastName=Doe"));
        assertTrue(medicalRecord.toString().contains("birthdate=01/01/2000"));
    }
}