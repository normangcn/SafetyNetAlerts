/**
 * 
 */
package DTOs;

import java.util.List;

import org.mapstruct.Mapper;

/**
 * @author gareth
 *
 */
@Mapper(componentModel="spring")
public interface PhoneAlertFireStationOutDTOMapper {
	List<PhoneAlertFireStationInDTO> fireStationsInDTOToPhoneAlertFireStationInDTO (List<FireStationsInDTO> sourceFireStations);
	default PhoneAlertFireStationInDTO map(FireStationsInDTO fireStation) {
		PhoneAlertFireStationInDTO fireStationInfoDTO = new PhoneAlertFireStationInDTO();
		fireStationInfoDTO.setStationNumber(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<PhoneAlertFireStationInDTO> personInDTOToPhoneAlertFireStationInDTO (List<PersonInDTO> sourcePerson);
	default PhoneAlertFireStationInDTO map(PersonInDTO person) {
		PhoneAlertFireStationInDTO personInfoDTO = new PhoneAlertFireStationInDTO();
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
}
