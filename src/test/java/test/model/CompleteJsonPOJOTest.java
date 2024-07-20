/**
 * 
 */
package test.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.model.CompleteJsonPOJO;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author gareth
 *
 */
@SpringBootTest(classes= SafetyNetAlertsApplication.class )
public class CompleteJsonPOJOTest {

    private CompleteJsonPOJO completeJsonPOJO;

    @BeforeEach
    public void setUp() {
        completeJsonPOJO = new CompleteJsonPOJO();
    }

    @Test
    public void testGettersAndSetters() {
        List<Person> persons = new ArrayList<>();
        List<FireStation> firestations = new ArrayList<>();
        List<MedicalRecord> medicalrecords = new ArrayList<>();

        completeJsonPOJO.setPersons(persons);
        completeJsonPOJO.setFirestations(firestations);
        completeJsonPOJO.setMedicalrecords(medicalrecords);

        assertEquals(persons, completeJsonPOJO.getPersons());
        assertEquals(firestations, completeJsonPOJO.getFirestations());
        assertEquals(medicalrecords, completeJsonPOJO.getMedicalrecords());
    }

    @Test
    public void testWithMethods() {
        List<Person> persons = new ArrayList<>();
        List<FireStation> firestations = new ArrayList<>();
        List<MedicalRecord> medicalrecords = new ArrayList<>();

        completeJsonPOJO.withPersons(persons);
        completeJsonPOJO.withFirestations(firestations);
        completeJsonPOJO.withMedicalrecords(medicalrecords);

        assertEquals(persons, completeJsonPOJO.getPersons());
        assertEquals(firestations, completeJsonPOJO.getFirestations());
        assertEquals(medicalrecords, completeJsonPOJO.getMedicalrecords());
    }

    @Test
    public void testAdditionalProperties() {
        String key = "key1";
        String value = "value1";

        completeJsonPOJO.setAdditionalProperty(key, value);
        Map<String, Object> expectedProperties = new HashMap<>();
        expectedProperties.put(key, value);

        assertEquals(expectedProperties, completeJsonPOJO.getAdditionalProperties());
    }

    @Test
    public void testEqualsAndHashCode() {
        CompleteJsonPOJO obj1 = new CompleteJsonPOJO(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        CompleteJsonPOJO obj2 = new CompleteJsonPOJO(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        assertEquals(obj1, obj2);
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

	
	  @Test public void testToString() { completeJsonPOJO.setPersons(new
	  ArrayList<>()); completeJsonPOJO.setFirestations(new ArrayList<>());
	  completeJsonPOJO.setMedicalrecords(new ArrayList<>());
	  
	  assertTrue(completeJsonPOJO.toString().startsWith(
	  "com.oc.safetynetalerts.model.CompleteJsonPOJO@"));
	  assertTrue(completeJsonPOJO.toString().contains("persons=[]"));
	  assertTrue(completeJsonPOJO.toString().contains("firestations=[]"));
	  assertTrue(completeJsonPOJO.toString().contains("medicalrecords=[]")); }
	 
}
