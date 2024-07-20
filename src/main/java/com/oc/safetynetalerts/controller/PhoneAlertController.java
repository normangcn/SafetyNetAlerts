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

import com.oc.safetynetalerts.DTOs.PhoneAlertFireStationOutDTO;
import com.oc.safetynetalerts.service.PhoneAlertService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/phoneAlert")
@RestController
@Slf4j
public class PhoneAlertController {

	@GetMapping()
	@ResponseBody
	public  List<PhoneAlertFireStationOutDTO> phoneAlert(@RequestParam String firestation) {
		List<PhoneAlertFireStationOutDTO> responseDTO = new ArrayList<PhoneAlertFireStationOutDTO>();
		PhoneAlertService phoneAlertTreatment = new PhoneAlertService();
		responseDTO = phoneAlertTreatment.phoneAlertService(firestation);
		return responseDTO ;
	}
}
