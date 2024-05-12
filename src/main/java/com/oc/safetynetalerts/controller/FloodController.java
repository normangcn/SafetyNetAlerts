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

import DTOs.FloodStationsStationsOutDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/flood")
@RestController
@Slf4j
public class FloodController {
	/*
	 * http://localhost:8080/flood/stations?stations=<a list of station_numbers>
	 * Cette url doit retourner une liste de tous les foyers desservis par la
	 * caserne. Cette liste doit regrouper les personnes par adresse. Elle doit
	 * aussi inclure le nom, le numéro de téléphone et l'âge des habitants, et faire
	 * figurer leurs antécédents médicaux (médicaments, posologie et allergies) à
	 * côté de chaque nom.
	 */
	
	@GetMapping("/stations")
	@ResponseBody
	public List<FloodStationsStationsOutDTO> floodStation(@RequestParam List<String> station){
		List<FloodStationsStationsOutDTO> responseDTO = new ArrayList<FloodStationsStationsOutDTO>();
		return responseDTO;
	}
}
