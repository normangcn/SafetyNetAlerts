/**
 * 
 */
package com.oc.safetynetalerts.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.DTOs.FireAddressOutDTO;
import com.oc.safetynetalerts.service.FireService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/fire")
@RestController
@Slf4j
public class FireController {

	@GetMapping()
	@ResponseBody
	public FireAddressOutDTO fireStationStationAddress(@RequestParam String address) {
		FireService fireAddressTreatment = new FireService();
		FireAddressOutDTO responseDTO = new FireAddressOutDTO();
		responseDTO = fireAddressTreatment.fireStationStationAddressService(address);
		return responseDTO;
	}
		

}
