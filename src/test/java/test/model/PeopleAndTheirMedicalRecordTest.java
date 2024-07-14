/**
 * 
 */
package test.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.model.PeopleAndTheirMedicalRecord;

import java.util.ArrayList;
import java.util.List;
/**
 * @author gareth
 *
 */
@SpringBootTest(classes= SafetyNetAlertsApplication.class )
public class PeopleAndTheirMedicalRecordTest {

    private PeopleAndTheirMedicalRecord record;

    @BeforeEach
    public void setUp() {
        record = new PeopleAndTheirMedicalRecord();
    }

    @Test
    public void testGettersAndSetters() {
        record.setFullName("John Doe");
        record.setFirstName("John");
        record.setLastName("Doe");
        record.setAddress("123 Main St");
        record.setCity("Springfield");
        record.setZip("12345");
        record.setPhone("555-1234");
        record.setEmail("john.doe@example.com");
        record.setBirthdate("01/01/2000");
        record.setMedications(new ArrayList<>());
        record.setAllergies(new ArrayList<>());
        record.setAge(24);

        assertEquals("John Doe", record.getFullName());
        assertEquals("John", record.getFirstName());
        assertEquals("Doe", record.getLastName());
        assertEquals("123 Main St", record.getAddress());
        assertEquals("Springfield", record.getCity());
        assertEquals("12345", record.getZip());
        assertEquals("555-1234", record.getPhone());
        assertEquals("john.doe@example.com", record.getEmail());
        assertEquals("01/01/2000", record.getBirthdate());
        assertEquals(24, record.getAge());
    }

    @Test
    public void testMedicationsAndAllergies() {
        List<String> medications = new ArrayList<>();
        medications.add("Medication1");
        record.setMedications(medications);
        assertEquals(medications, record.getMedications());

        List<String> allergies = new ArrayList<>();
        allergies.add("Allergy1");
        record.setAllergies(allergies);
        assertEquals(allergies, record.getAllergies());
    }
}
