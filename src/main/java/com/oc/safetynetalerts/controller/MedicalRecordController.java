/**
 * 
 */
package com.oc.safetynetalerts.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.repository.JsonReaderRepository;
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
	JsonReaderRepository repository = new JsonReaderRepository();
	@GetMapping(value="/{p1}")
	public String test(@PathVariable("p1") String p1, @RequestParam("p2")String p2) {
		return StringUtils.concatNames(p1, p2);
	}
	/*
	 * @GetMapping(value= "/{name}")
	 * 
	 * @ResponseBody
	 * 
	 * public List<MedicalRecord> singleMedicalRecord(@PathVariable("name") String
	 * fullName) { List<MedicalRecord> singleMedicalRecordByFullName = null;
	 * 
	 * try { singleMedicalRecordByFullName =
	 * repository.extractMedicalRecordsDataFromJsonNode(); } catch
	 * (JsonParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return
	 * singleMedicalRecordByFullName; }
	 */
	
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
