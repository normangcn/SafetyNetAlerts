/**
 * 
 */
package com.oc.safetynetalerts;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author gareth
 *
 */
public class GeneralApplicationValuesCheck {
	@Test
	@DisplayName("Time delay check")
	public void checkForTimeDelay() { //checking for time delays in milliseconds
		long timeNow = System.currentTimeMillis();
		long timeDiffered = System.currentTimeMillis();
		Assert.assertEquals(timeDiffered, timeNow);
	}
}
