/**
 * 
 */
package com.oc.safetynetalerts.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.KidsAndAdultsAtAddress;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.repository.JsonReaderRepository;
import com.oc.safetynetalerts.utils.StringUtils;

/**
 * @author gareth
 *
 */
@Service
public class PersonService {
	public static List<Person> fullNameCreationPerson() throws IOException {
		List<Person> allPeople = new ArrayList<>();
		try {
			JsonReaderRepository repository = new JsonReaderRepository();
					allPeople = repository.extractPersonDataFromJsonNode();
			for (Person personElement : allPeople) {
				String firstNameTemp = null;
				String lastNameTemp = null;
				firstNameTemp = personElement.getFirstName();
				lastNameTemp = personElement.getLastName();
				String nameConcated = StringUtils.concatNames(firstNameTemp, lastNameTemp);
				personElement.setFullName(nameConcated);
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allPeople;
	}
	public List<KidsAndAdultsAtAddress> kidsAndAdultsListAtAddress(){
		
		return null;
		
	}
}
