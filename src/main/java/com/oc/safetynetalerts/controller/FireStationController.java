/**
 * 
 */
package com.oc.safetynetalerts.controller;



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

import com.oc.safetynetalerts.model.FireStation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */
@RequestMapping("/firestation")
@RestController
@Slf4j
public class FireStationController {
    
    @GetMapping("/test")
    public String test() {
	String test = "test";
	return test;
    }
    
    @GetMapping(value= "/{station_number}")
    @ResponseBody
    public FireStation fireStationStationNumber(@PathVariable("station_number") int station) {
	FireStation getFireStation = new FireStation();
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
