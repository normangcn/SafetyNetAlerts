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
		fireStationInfoDTO.setAddressFirestation(fireStation.getAddress());
		fireStationInfoDTO.setStationNumberFirestation(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<FireAddressOutDTO> personInDTOToFireAddressInDTO (List<PersonInDTO> sourcePerson);
	default FireAddressOutDTO map(PersonInDTO person) {
		FireAddressOutDTO personInfoDTO = new FireAddressOutDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
	List<FireAddressOutDTO> medicalRecordsInDTOToFireAddressInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FireAddressOutDTO map(MedicalRecordsInDTO medicalRecords) {
		FireAddressOutDTO medicalRecordsInfoDTO = new FireAddressOutDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
		medicalRecordsInfoDTO.setMedicalRecMedication(medicalRecords.getMedications());
		medicalRecordsInfoDTO.setMedicalRecAllergies(medicalRecords.getAllergies());
        return medicalRecordsInfoDTO;
    }
}
