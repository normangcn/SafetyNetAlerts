/**
 * 
 */
package com.oc.safetynetalerts.DTOs;

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
        return firestationStationNumberPeople;
    }

}
