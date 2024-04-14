/**
 * 
 */
package DTOs;

import java.util.List;

import org.mapstruct.Mapper;
import com.oc.safetynetalerts.model.Person;

/**
 * @author gareth
 *
 */
@Mapper(componentModel= "spring")
public interface FireStationNumberOutDTOMapper {

	List<FirestationStationNumberPeople> personToFirestationStationNumberOutDTO (List<Person> sourcePerson);
	
	default FirestationStationNumberPeople map(List<Person> filteredPeople) {
		FirestationStationNumberPeople firestationStationNumberPeople = new FirestationStationNumberPeople();
		firestationStationNumberPeople.setFirstName(filteredPeople.getFirstName());
		firestationStationNumberPeople.setLastName(filteredPeople.getLastName());
		firestationStationNumberPeople.setAddress(filteredPeople.getAddress());
		firestationStationNumberPeople.setPhone(filteredPeople.getPhone());
        return firestationStationNumberPeople;
    }

}
