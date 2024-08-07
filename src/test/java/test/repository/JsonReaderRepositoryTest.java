/**
 * 
 */
package test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.oc.safetynetalerts.repository.JsonReaderRepository;

/**
 * @author NORMAN Gareth
 *
 */
@SpringBootTest
public class JsonReaderRepositoryTest{

    @Test
    public void starterJsonFileReader() throws JsonParseException, JsonMappingException, IOException {
	
	JsonNode testJsonFileReader = JsonReaderRepository.starterJsonFileReader();
	
	assertThat(testJsonFileReader).isNotNull();
	
    }
}
