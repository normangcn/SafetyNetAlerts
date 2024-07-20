/**
 * 
 */
package test.utils;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.oc.safetynetalerts.utils.DateUtils;

/**
 * @author gareth
 *
 */
public class DateUtilsTest {
	@DisplayName("Calculate age. Should Display 5 years")
	@Test
	public static void whenDatenow_ifdateMinus5Years_then5Years() {
		LocalDate dateMinusFiveYears = LocalDate.now().minus(5, ChronoUnit.YEARS);
		int age = DateUtils.calculateAge(dateMinusFiveYears);
		assertEquals(age,5);
	}
	@DisplayName("Make a String based date into a proper Date")
	@Test
	public static void whenStringDate_ifStringParsed_thenDateAsString() {
		String dateAsString = "03/06/1984";
		LocalDate stringTransformed = DateUtils.stringToLocalDateFormatter(dateAsString);
		assertEquals(stringTransformed,"03/06/1984");
	}
	@DisplayName("Should check for a person being a minor based on the age")
	@Test
	public static void whenAge_ifAgeUnder18_thenIsAnAdult() {
		int age = 17;
		boolean isAKid = DateUtils.validateKids(age);
		assertThat(isAKid);
	}
	@DisplayName("Should check for a person being a adult based on the age")
	@Test
	public static void whenAge_ifAgeOver18_thenIsAKid() {
		int age = 18;
		boolean isAnAdult = DateUtils.validateAdult(age);
		assertThat(isAnAdult);
	}
}
