/**
 * 
 */
package com.oc.safetynetalerts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.repository.GlobalRepo;
import com.oc.safetynetalerts.utils.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */
@RequestMapping("/medicalRecord")
@RestController
@Slf4j
public class MedicalRecordController {
	@GetMapping(value="/full")
	public List<MedicalRecord> fullList()
	{		
		return GlobalRepo.medicalRecords;
		
	}
	@GetMapping(value="/{p1}")
	public String test(@PathVariable("p1") String p1, @RequestParam("p2")String p2) 
	{
		return StringUtils.concatNames(p1, p2);
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addMedicalRecord(@RequestBody MedicalRecord newMedicalRecord) {
	return "Medical record added as:" + newMedicalRecord;
    }
    
    @PutMapping(value= "/{firstName}{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public String updateMedicalRecord(@PathVariable("firstName lastName") String medicalRecord, @RequestBody MedicalRecord updateMedicalRecord) {
	return "Medical record for: "+ medicalRecord + " updated.";
    }
    @DeleteMapping(value = "/{firstName}{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMedicalRecord(@PathVariable("firstName lastName") String medicalRecord) {
    }

}
