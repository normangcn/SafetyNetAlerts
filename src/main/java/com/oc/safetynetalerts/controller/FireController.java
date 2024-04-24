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
		/*
		 * http://localhost:8080/childAlert?address=<address> Cette url doit retourner
		 * une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant à cette
		 * adresse. La liste doit comprendre le prénom et le nom de famille de chaque
		 * enfant, son âge et une liste des autres membres du foyer. S'il n'y a pas
		 * d'enfant, cette url peut renvoyer une chaîne vide.
		 * 
		 */		return null;
	}
}
