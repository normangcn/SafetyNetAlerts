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

import com.oc.safetynetalerts.DTOs.CommunityEmailCityOutDTO;
import com.oc.safetynetalerts.service.CommunityEmailService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gareth
 *
 */
@RequestMapping("/communityEmail")
@RestController
@Slf4j
public class CommunityEmailController {

	@GetMapping()
	@ResponseBody
	public List<CommunityEmailCityOutDTO> communityEmail(@RequestParam String city ){
		List<CommunityEmailCityOutDTO> responseDTO = new ArrayList<CommunityEmailCityOutDTO>();
		CommunityEmailService communityEmailTreatment = new CommunityEmailService();
		responseDTO= communityEmailTreatment.communityEmailService(city);
		return responseDTO;
	}
	
}
