/**
 * 
 */
package com.oc.safetynetalerts.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.repository.GlobalRepo;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */
@RequestMapping("/person")
@RestController
@Slf4j
public class PersonController {
	JsonReaderRepository repository = new JsonReaderRepository();
	@GetMapping(value= "/{name}")
    @ResponseBody
    public List<Person> singleMedicalRecord(@PathVariable("name") String fullName) {
    	List<Person> singlePersonRecordByFullName = null;
	try {
		singlePersonRecordByFullName = repository.extractPersonDataFromJsonNode();
		for(Person o : singlePersonRecordByFullName) {
			//String fullName = firstName + lastName;
		}
		
				
	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return singlePersonRecordByFullName;
    }
	
	@GetMapping(value="/childAlert")
	public List<Person> kidsAndAdultsListAtAddress(@PathVariable("Address") String address)
	{
		return GlobalRepo.person;//TODO return the actual data. Not the generic basic List
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addPerson(@RequestBody Person newPerson) {
	return "Record added as:" + newPerson;
    }
    
    @PutMapping(value= "/{firstName}{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public String updatePerson(@PathVariable("firstName lastName") String person, @RequestBody Person updatePerson) {
	return "Record for: "+ person + " updated.";
    }
    @DeleteMapping(value = "/{firstName}{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable("firstName lastName") String person) {
    }
}
