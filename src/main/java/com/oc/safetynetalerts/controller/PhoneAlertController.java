/**
 * 
 */
package com.oc.safetynetalerts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import DTOs.PhoneAlertFireStationOutDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/phoneAlert")
@RestController
@Slf4j
public class PhoneAlertController {
	/*
	 * http://localhost:8080/phoneAlert?firestation=<firestation_number> Cette url
	 * doit retourner une liste des numéros de téléphone des résidents desservis par
	 * la caserne de pompiers. Nous l'utiliserons pour envoyer des messages texte
	 * d'urgence à des foyers spécifiques.
	 */
	
	@GetMapping(value = "/{firestation_number}")
	@ResponseBody
	public  List<PhoneAlertFireStationOutDTO> phoneAlert(@PathVariable("firestation_number") String stationNumber) {
		List<PhoneAlertFireStationOutDTO> responseDTO = new ArrayList<PhoneAlertFireStationOutDTO>();
		
		return responseDTO ;
		
	}
}
