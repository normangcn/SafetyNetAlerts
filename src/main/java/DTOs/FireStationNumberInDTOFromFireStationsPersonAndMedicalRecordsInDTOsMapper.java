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
	List<FirestationStationNumberInDTO> fireStationsInDTOToFirestationStationNumberInDTO (List<FireStationsInDTO> sourceFireStations);
	default FirestationStationNumberInDTO map(FireStationsInDTO fireStation) {
		FirestationStationNumberInDTO fireStationInfoDTO = new FirestationStationNumberInDTO();
		fireStationInfoDTO.setAddressFirestation(fireStation.getAddress());
		fireStationInfoDTO.setStationNumberFirestation(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<FirestationStationNumberInDTO> personInDTOToFirestationStationNumberInDTO (List<PersonInDTO> sourcePerson);
	default FirestationStationNumberInDTO map(PersonInDTO person) {
		FirestationStationNumberInDTO personInfoDTO = new FirestationStationNumberInDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
	List<FirestationStationNumberInDTO> medicalRecordsInDTOToFirestationStationNumberInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FirestationStationNumberInDTO map(MedicalRecordsInDTO medicalRecords) {
		FirestationStationNumberInDTO medicalRecordsInfoDTO = new FirestationStationNumberInDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
        return medicalRecordsInfoDTO;
    }
}
