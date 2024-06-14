/**
 * 
 */
package com.oc.safetynetalerts.DTOs;

import java.util.List;

import org.mapstruct.Mapper;

/**
 * @author gareth
 *
 */
@Mapper(componentModel="spring")
public interface PhoneAlertFireStationOutDTOMapper {
	List<PhoneAlertFireStationOutDTO> fireStationsInDTOToPhoneAlertFireStationInDTO (List<FireStationsInDTO> sourceFireStations);
	default PhoneAlertFireStationOutDTO map(FireStationsInDTO fireStation) {
		PhoneAlertFireStationOutDTO fireStationInfoDTO = new PhoneAlertFireStationOutDTO();
        return fireStationInfoDTO;
    }
	
	List<PhoneAlertFireStationOutDTO> personInDTOToPhoneAlertFireStationInDTO (List<PersonInDTO> sourcePerson);
	default PhoneAlertFireStationOutDTO map(PersonInDTO person) {
		PhoneAlertFireStationOutDTO personInfoDTO = new PhoneAlertFireStationOutDTO();
        return personInfoDTO;
    }
}
