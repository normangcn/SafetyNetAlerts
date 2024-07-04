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

import com.oc.safetynetalerts.DTOs.PersonInfoFirstNameAndLastNameOutDTO;
import com.oc.safetynetalerts.service.PersonInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/personInfo")
@RestController
@Slf4j
public class PersonInfoController {

	@GetMapping()
	@ResponseBody
	public  List<PersonInfoFirstNameAndLastNameOutDTO> personInfo(@RequestParam String firstName, @RequestParam String lastName) {
		List<PersonInfoFirstNameAndLastNameOutDTO> responseDTO = new ArrayList<PersonInfoFirstNameAndLastNameOutDTO>();
		PersonInfoService personInfoTreatment= new PersonInfoService();
		responseDTO = personInfoTreatment.personInfoService(firstName, lastName);
		return responseDTO;
	}
}
