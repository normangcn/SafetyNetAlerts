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

@Mapper(componentModel = "spring")
public interface FireAddressInDTOFromPersonMedicalRecordsAndFireStationInDTOsMapper {
	

	List<FireAddressInDTO> fireStationsInDTOToFireAddressInDTO (List<FireStationsInDTO> sourceFireStations);
	default FireAddressInDTO map(FireStationsInDTO fireStation) {
		FireAddressInDTO fireStationInfoDTO = new FireAddressInDTO();
		fireStationInfoDTO.setAddressFirestation(fireStation.getAddress());
		fireStationInfoDTO.setStationNumberFirestation(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<FireAddressInDTO> personInDTOToFireAddressInDTO (List<PersonInDTO> sourcePerson);
	default FireAddressInDTO map(PersonInDTO person) {
		FireAddressInDTO personInfoDTO = new FireAddressInDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
	List<FireAddressInDTO> medicalRecordsInDTOToFireAddressInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FireAddressInDTO map(MedicalRecordsInDTO medicalRecords) {
		FireAddressInDTO medicalRecordsInfoDTO = new FireAddressInDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
		medicalRecordsInfoDTO.setMedicalRecMedication(medicalRecords.getMedications());
		medicalRecordsInfoDTO.setMedicalRecAllergies(medicalRecords.getAllergies());
        return medicalRecordsInfoDTO;
    }
}
