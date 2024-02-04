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
@Mapper(componentModel= "spring")
public interface FireStationNumberInDTOFromFireStationsPersonAndMedicalRecordsInDTOsMapper {
	List<FirestationStationNumberOutDTO> fireStationsInDTOToFirestationStationNumberInDTO (List<FireStationsInDTO> sourceFireStations);
	default FirestationStationNumberOutDTO map(FireStationsInDTO fireStation) {
		FirestationStationNumberOutDTO fireStationInfoDTO = new FirestationStationNumberOutDTO();
		fireStationInfoDTO.setAddressFirestation(fireStation.getAddress());
		fireStationInfoDTO.setStationNumberFirestation(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<FirestationStationNumberOutDTO> personInDTOToFirestationStationNumberInDTO (List<PersonInDTO> sourcePerson);
	default FirestationStationNumberOutDTO map(PersonInDTO person) {
		FirestationStationNumberOutDTO personInfoDTO = new FirestationStationNumberOutDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
	List<FirestationStationNumberOutDTO> medicalRecordsInDTOToFirestationStationNumberInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FirestationStationNumberOutDTO map(MedicalRecordsInDTO medicalRecords) {
		FirestationStationNumberOutDTO medicalRecordsInfoDTO = new FirestationStationNumberOutDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
        return medicalRecordsInfoDTO;
    }
}
