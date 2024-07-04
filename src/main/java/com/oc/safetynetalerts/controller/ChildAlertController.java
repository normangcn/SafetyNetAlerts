/**
 * 
 */
package com.oc.safetynetalerts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.DTOs.ChildAlertAddressOutDTO;
import com.oc.safetynetalerts.service.ChildAlertService;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/childAlert")
@RestController
@Slf4j
public class ChildAlertController {

	@GetMapping()
	@ResponseBody
	public List<ChildAlertAddressOutDTO> childAlertAddress(@RequestParam String address ) {
		List<ChildAlertAddressOutDTO> responseDTO = new ArrayList<ChildAlertAddressOutDTO>();
		ChildAlertService childAlertTreatment = new ChildAlertService();
		responseDTO = childAlertTreatment.childAlertAddressService(address);
		return responseDTO;	
	}

}
