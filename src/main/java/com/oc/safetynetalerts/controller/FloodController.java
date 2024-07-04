/**
 * 
 */
package com.oc.safetynetalerts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.DTOs.FloodStationsStationsOutDTO;
import com.oc.safetynetalerts.service.FloodService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/flood")
@RestController
@Slf4j
public class FloodController {

	
	@GetMapping("/stations")
	@ResponseBody
	public List<FloodStationsStationsOutDTO> floodStation(@RequestParam List<String> stations){
		List<FloodStationsStationsOutDTO> responseDTO = new ArrayList<FloodStationsStationsOutDTO>();
		FloodService floodTreatment = new FloodService();
		responseDTO = floodTreatment.floodStationService(stations);
		
		return responseDTO;
	}
}
