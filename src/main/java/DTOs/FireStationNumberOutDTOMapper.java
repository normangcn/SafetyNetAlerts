/**
 * 
 */
package DTOs;

import java.util.List;

import org.mapstruct.Mapper;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;

/**
 * @author gareth
 *
 */
@Mapper(componentModel= "spring")
public interface FireStationNumberOutDTOMapper {

	
	List<FirestationStationNumberOutDTO> personToFirestationStationNumberOutDTO (List<Person> sourcePerson);
	default FirestationStationNumberOutDTO map(Person person) {
		FirestationStationNumberOutDTO personInfoDTO = new FirestationStationNumberOutDTO();
        return personInfoDTO;
    }

}
