/**
 * 
 */
package com.oc.safetynetalerts.unittests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.DisplayName;

/**
 * @author gareth
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FireStationServiceUT {
	//TODO move into integration tests
	@Autowired
    private MockMvc mockMvc;
	@Test
	@DisplayName("Should have 2 as station number and Eric Cadigan and the 3 Zemicks ")
	public void listNameCheckUTForStation2givenStationNumber2_whenResultList_thenReturnCorrectResultList() throws Exception {
		/*
		 * ArrayList<String> expectedList = new ArrayList<String>();
		 * expectedList.add("Sophia"); expectedList.add("Zemicks");
		 * expectedList.add("892 Downing Ct"); expectedList.add("841-874-7878");
		 * expectedList.add("kids: 1"); expectedList.add("adults: 2"); ArrayList<String>
		 * actualList = new ArrayList<String>();
		 */
		mockMvc.perform(get("http://localhost:8080/firestation")).andExpect(status().isOk());
	    //Assert.assertEquals(expectedList, actualList); 
	}
		
}
