/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.persons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/persons")
@RestController
@Slf4j
public class PersonController {
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String addPerson(@RequestBody Person newPerson) {
		persons.add(newPerson);
		return "Person added as:" + newPerson;
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public String updatePerson(@RequestParam String firstName, @RequestParam String lastName, @RequestBody Person updatePerson) {
		for(Person personElement:persons) {
	        if(personElement.getFirstName().equals(firstName)&&personElement.getLastName().equals(lastName)) {
	        	personElement.setAddress(updatePerson.getAddress());
	        	personElement.setCity(updatePerson.getCity());
	        	personElement.setZip(updatePerson.getZip());
	        	personElement.setPhone(updatePerson.getPhone());
	        	personElement.setEmail(updatePerson.getEmail());
	        	
	        }
	    }
		return "Record for " + firstName +" " + lastName + " updated.";
	}

	@DeleteMapping()
	@ResponseStatus(HttpStatus.OK)
	public String deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
		List<Person> deletePersons = new ArrayList<>();
		Person deletePerson = new Person();
		deletePerson.setFirstName(firstName);
		deletePerson.setLastName(lastName);
		deletePersons.add(deletePerson);
		persons.removeAll(deletePersons);

		return "Record for " + firstName + " " + lastName +" deleted.";
	}
}
