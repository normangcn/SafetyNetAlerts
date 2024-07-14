/**
 * 
 */
package test.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.model.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * @author gareth
 *
 */
@SpringBootTest(classes= SafetyNetAlertsApplication.class )
public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testGettersAndSetters() {
        UUID id = UUID.randomUUID();
        person.setId(id);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("123 Main St");
        person.setCity("Springfield");
        person.setZip("12345");
        person.setPhone("555-1234");
        person.setEmail("john.doe@example.com");

        assertEquals(id, person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("123 Main St", person.getAddress());
        assertEquals("Springfield", person.getCity());
        assertEquals("12345", person.getZip());
        assertEquals("555-1234", person.getPhone());
        assertEquals("john.doe@example.com", person.getEmail());
    }

    @Test
    public void testAdditionalProperties() {
        Map<String, Object> additionalProps = new HashMap<>();
        additionalProps.put("key", "value");
        person.setAdditionalProperty("key", "value");

        assertEquals(additionalProps, person.getAdditionalProperties());
    }

    @Test
    public void testEqualsAndHashCode() {
    	Person obj1 = new Person("John","Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
        Person obj2 = new Person("John","Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");

        assertEquals(obj1, obj2);
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    public void testToString() {
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("123 Main St");

        
        assertTrue(person.toString().startsWith("com.oc.safetynetalerts.model.Person@")&&person.toString().contains("John"));
    }
}
