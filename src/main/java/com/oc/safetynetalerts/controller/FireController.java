/**
 * 
 */
package com.oc.safetynetalerts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import DTOs.FirestationStationNumberOutDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/fire")
@RestController
@Slf4j
public class FireController {
	
	@GetMapping(value = "/{station_address}")
	@ResponseBody
	public FirestationStationNumberOutDTO fireStationStationAddress(@PathVariable("station_address") String address) {
		
		return null;
	}
}
