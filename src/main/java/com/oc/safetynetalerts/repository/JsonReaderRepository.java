/**
 * 
 */
package com.oc.safetynetalerts.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;
import com.oc.safetynetalerts.service.ObjectMapperService;


import lombok.extern.slf4j.Slf4j;

/**
 * @author NORMAN Gareth
 *
 */

  @Component
  @RequestMapping
  @Slf4j
  public class JsonReaderRepository {
    public static JsonNode starterJsonFileReader() {
    ObjectMapper mapper = ObjectMapperService.getInstance();
    JsonNode JsonFileContent = null;
	try {
	    File jsonFile = new File("src/main/resources/data.json").getAbsoluteFile();
	    JsonFileContent = ((JsonNode)mapper.readTree(jsonFile));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return JsonFileContent;
    }
    
    
    public List<Person> extractPersonDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode personFromJasonFileJsonNode = starterJsonFileReader().get("person");
    	List<Person> personFromJsonNode = new ArrayList<>();
    	for(JsonNode o : personFromJasonFileJsonNode) {
    		String str= mapper.writeValueAsString(o);
    		personFromJsonNode.add(mapper.readValue(str, Person.class));
    	}
    	
    	return personFromJsonNode;
    }
    
    public List<FireStation> extractFireStationsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode fireStationsFromJasonFileJsonNode = starterJsonFileReader().get("firestations");
    	List<FireStation> fireStationsFromJsonNode = new ArrayList<>();
        for(JsonNode o : fireStationsFromJasonFileJsonNode) {
    		String str= mapper.writeValueAsString(o);
    		fireStationsFromJsonNode.add(mapper.readValue(str, FireStation.class));
    	}    	
    	return fireStationsFromJsonNode;
    }
    
    public List<MedicalRecord> extractMedicalRecordsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode medicalRecordsFromJasonFileJsonNode = starterJsonFileReader().get("medicalrecords");
    	List<MedicalRecord> medicalRecordsFromJsonNode = new ArrayList<>();
        for(JsonNode o : medicalRecordsFromJasonFileJsonNode) {
    		String str= mapper.writeValueAsString(o);
    		medicalRecordsFromJsonNode.add(mapper.readValue(str, MedicalRecord.class));
    	}
    	
    	return medicalRecordsFromJsonNode;
    }
	/*
	 * public void convertJsonToJavaClass(URL inputJsonUrl, File
	 * outputJavaClassDirectory, String packageName, String javaClassName) throws
	 * IOException { JCodeModel jcodeModel = new JCodeModel();
	 * 
	 * GenerationConfig config = new DefaultGenerationConfig() {
	 * 
	 * @Override public boolean isGenerateBuilders() { return true; }
	 * 
	 * @Override public SourceType getSourceType() { return SourceType.JSON; } };
	 * 
	 * SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new
	 * Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
	 * mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);
	 * 
	 * jcodeModel.build(outputJavaClassDirectory); }
	 */
}