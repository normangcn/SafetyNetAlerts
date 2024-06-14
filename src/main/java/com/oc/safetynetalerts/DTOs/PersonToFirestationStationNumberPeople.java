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
public interface PersonToFirestationStationNumberPeople {
	List<FirestationStationNumberPeople> map(List<Person> person);
	default FirestationStationNumberPeople map(Person person) {
		FirestationStationNumberPeople firestationStationNumberPeople = new FirestationStationNumberPeople();
		firestationStationNumberPeople.setFirstName(person.getFirstName());
		firestationStationNumberPeople.setLastName(person.getLastName());
		firestationStationNumberPeople.setAddress(person.getAddress());
		firestationStationNumberPeople.setPhone(person.getPhone());
        return firestationStationNumberPeople;
    }
}
