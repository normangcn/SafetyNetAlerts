/**
 * 
 */
package com.oc.safetynetalerts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */
@RequestMapping("/person")
@RestController
@Slf4j
public class PersonController {
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
