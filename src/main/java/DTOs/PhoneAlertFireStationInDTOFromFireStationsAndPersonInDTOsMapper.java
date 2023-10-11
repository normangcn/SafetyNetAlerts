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
public interface PhoneAlertFireStationInDTOFromFireStationsAndPersonInDTOsMapper {
	List<PhoneAlertFireStationInDTO> fireStationsInDTOToPhoneAlertFireStationInDTO (List<FireStationsInDTO> sourceFireStations);
	default PhoneAlertFireStationInDTO map(FireStationsInDTO fireStation) {
		PhoneAlertFireStationInDTO fireStationInfoDTO = new PhoneAlertFireStationInDTO();
		fireStationInfoDTO.setAddressFirestation(fireStation.getAddress());
		fireStationInfoDTO.setStationNumber(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<PhoneAlertFireStationInDTO> personInDTOToPhoneAlertFireStationInDTO (List<PersonInDTO> sourcePerson);
	default PhoneAlertFireStationInDTO map(PersonInDTO person) {
		PhoneAlertFireStationInDTO personInfoDTO = new PhoneAlertFireStationInDTO();
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
}
