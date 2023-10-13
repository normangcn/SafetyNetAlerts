/**
 * 
 */
package com.oc.safetynetalerts.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/{station_number}")
    @ResponseBody
    public String fireStationStationNumber(@PathVariable("station_number") String station) {
	return station;
    }
    
}
