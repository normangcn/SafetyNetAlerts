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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */
@RequestMapping("/firestation")
@RestController
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class FireStationController {
	JsonReaderRepository repository = new JsonReaderRepository();
    @GetMapping("/test")
    public String test() {
	String test = "test";
	return test;
    }
    
    @GetMapping(value= "/{station_number}")
    @ResponseBody
    public List<FireStation> fireStationStationNumber(@PathVariable("station_number") int station) {
    	List<FireStation> getFireStation = new FireStation(null, station);
    	
	try {
	    getFireStation = repository.extractFireStationsDataFromJsonNode();
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
	return getFireStation;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addFireStation(@RequestBody FireStation newFireStation) {
	return "Station added as:" + newFireStation;
    }
    
    @PutMapping(value= "/{station_number}")
    @ResponseStatus(HttpStatus.OK)
    public String updateFireStation(@PathVariable int station_number, @RequestBody FireStation updateFireStation) {
	return "Station "+ station_number + " information updated.";
    }
    @DeleteMapping(value = "/{station_number}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFireStation(@PathVariable("station_number") int station) {
    }
}
