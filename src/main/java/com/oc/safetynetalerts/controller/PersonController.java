/**
 * 
 */
package com.oc.safetynetalerts.controller;

import static com.oc.safetynetalerts.repository.GlobalRepo.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		person.add(newPerson);
		return "Person added as:" + newPerson;
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public String updatePerson(@RequestParam String personFirstName, @RequestParam String personLastName, @RequestBody Person updatePerson) {
		
		return "Station at address " + personFirstName +" " + personLastName + " station id updated.";
	}

	@DeleteMapping(value = "/{station_number}")
	@ResponseStatus(HttpStatus.OK)
	public void deletePerson(@PathVariable("station_number") int station) {
	}
}
