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
import com.oc.safetynetalerts.model.FireStation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest(classes= SafetyNetAlertsApplication.class )
public class FireStationTest {

	private FireStation fireStation;

	@BeforeEach
	public void setUp() {
		fireStation = new FireStation();
	}

	@Test
	public void testGettersAndSetters() {
		UUID id = UUID.randomUUID();
		String address = "123 Main St";
		String station = "Station 1";

		fireStation.setId(id);
		fireStation.setAddress(address);
		fireStation.setStation(station);

		assertEquals(id, fireStation.getId());
		assertEquals(address, fireStation.getAddress());
		assertEquals(station, fireStation.getStation());
	}

	@Test
	public void testWithMethods() {
		String address = "456 Elm St";
		String station = "Station 2";

		fireStation.withAddress(address);
		fireStation.withStation(station);

		assertEquals(address, fireStation.getAddress());
		assertEquals(station, fireStation.getStation());
	}

	@Test
	public void testAdditionalProperties() {
		String key = "key1";
		String value = "value1";

		fireStation.setAdditionalProperty(key, value);
		Map<String, Object> expectedProperties = new HashMap<>();
		expectedProperties.put(key, value);

		assertEquals(expectedProperties, fireStation.getAdditionalProperties());
	}

	@Test
	public void testEqualsAndHashCode() {
		FireStation fireStation1 = new FireStation("123 Main St", "Station 1");
		FireStation fireStation2 = new FireStation("123 Main St", "Station 1");

		assertEquals(fireStation1, fireStation2);
		assertEquals(fireStation1.hashCode(), fireStation2.hashCode());
	}

	@Test
	public void testToString() {
		fireStation.setAddress("123 Main St");
        fireStation.setStation("Station 1");


        assertTrue(fireStation.toString().startsWith("com.oc.safetynetalerts.model.FireStation@"));
        assertTrue(fireStation.toString().contains("address=123 Main St"));
        assertTrue(fireStation.toString().contains("station=Station 1"));
	}
}
