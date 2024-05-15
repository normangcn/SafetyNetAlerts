/**
 * 
 */
package DTOs;

import java.util.List;

import org.mapstruct.Mapper;


/**
 * @author NORMAN Gareth
 *
 */

@Mapper(componentModel = "spring")
public interface FireAddressOutDTOMapper {
	

	List<FireAddressOutDTO> fireStationsInDTOToFireAddressInDTO (List<FireStationsInDTO> sourceFireStations);
	default FireAddressOutDTO map(FireStationsInDTO fireStation) {
		FireAddressOutDTO fireStationInfoDTO = new FireAddressOutDTO();
        return fireStationInfoDTO;
    }
	
	List<FireAddressOutDTO> personInDTOToFireAddressInDTO (List<PersonInDTO> sourcePerson);
	default FireAddressOutDTO map(PersonInDTO person) {
		FireAddressOutDTO personInfoDTO = new FireAddressOutDTO();
        return personInfoDTO;
    }
	List<FireAddressOutDTO> medicalRecordsInDTOToFireAddressInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FireAddressOutDTO map(MedicalRecordsInDTO medicalRecords) {
		FireAddressOutDTO medicalRecordsInfoDTO = new FireAddressOutDTO();
        return medicalRecordsInfoDTO;
    }
}
