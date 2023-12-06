/**
 * 
 */
package com.oc.safetynetalerts.repository;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
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
    public static JsonNode StarterJsonFileReader() {
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
    
    
    public static Person extractPersonDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	final JsonNode personFromJasonFileJsonNode = StarterJsonFileReader().get("person");
    	Person personFromJsonNode = mapper.treeToValue(personFromJasonFileJsonNode, Person.class);
		return personFromJsonNode;
    }
    
    public List<FireStation> extractFireStationsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	JsonNode fireStationsFromJasonFileJsonNode = StarterJsonFileReader().get("firestations");
    	List<FireStation> fireStationsFromJsonNode = mapper.reader().forType(new TypeReference<List<FireStation>>() {}).readValue(fireStationsFromJasonFileJsonNode);
    	return fireStationsFromJsonNode;
    }
    
    public MedicalRecord extractMedicalRecordsDataFromJsonNode() throws JsonParseException, JsonMappingException,
    IOException {
    	ObjectMapper mapper = ObjectMapperService.getInstance();
    	final JsonNode medicalRecordsFromJasonFileJsonNode = StarterJsonFileReader().get("medicalrecords");
    	MedicalRecord medicalRecordsFromJsonNode = mapper.treeToValue(medicalRecordsFromJasonFileJsonNode, MedicalRecord.class);
		return medicalRecordsFromJsonNode;
    }
    public void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName) 
    		  throws IOException {
    		    JCodeModel jcodeModel = new JCodeModel();

    		    GenerationConfig config = new DefaultGenerationConfig() {
    		        @Override
    		        public boolean isGenerateBuilders() {
    		            return true;
    		        }

    		        @Override
    		        public SourceType getSourceType() {
    		            return SourceType.JSON;
    		        }
    		    };

    		    SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
    		    mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

    		    jcodeModel.build(outputJavaClassDirectory);
    		}
}