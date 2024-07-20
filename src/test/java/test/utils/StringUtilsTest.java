/**
 * 
 */
package test.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.oc.safetynetalerts.SafetyNetAlertsApplication;
import com.oc.safetynetalerts.utils.StringUtils;

/**
 * @author gareth
 *
 */
@SpringBootTest(classes= SafetyNetAlertsApplication.class )
public class StringUtilsTest {
	final String stringTestOne = "Banana";
	final String stringTestTwo = "Peanut";
	@DisplayName("Should concatenate Banana and Peanut into one string")
	@Test
	public void concatNamesTest() {
	String result;
	result = StringUtils.concatNames(stringTestOne, stringTestTwo);
	assertEquals(result, "Banana Peanut");
	}

}
