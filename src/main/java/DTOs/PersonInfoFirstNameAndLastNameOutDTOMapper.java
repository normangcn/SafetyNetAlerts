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
public interface PersonInfoFirstNameAndLastNameOutDTOMapper {
	List<PersonInfoFirstNameAndLastNameOutDTO> personInDTOToPersonInfoFirstNameAndLastNameInDTO (List<PersonInDTO> sourcePerson);
	default PersonInfoFirstNameAndLastNameOutDTO map(PersonInDTO person) {
		PersonInfoFirstNameAndLastNameOutDTO personInfoDTO = new PersonInfoFirstNameAndLastNameOutDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonEmail(person.getEmail());
        return personInfoDTO;
    }
	List<PersonInfoFirstNameAndLastNameOutDTO> medicalRecordsInDTOToPersonInfoFirstNameAndLastNameInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default PersonInfoFirstNameAndLastNameOutDTO map(MedicalRecordsInDTO medicalRecords) {
		PersonInfoFirstNameAndLastNameOutDTO medicalRecordsInfoDTO = new PersonInfoFirstNameAndLastNameOutDTO();
		medicalRecordsInfoDTO.setMedicalRecMedication(medicalRecords.getMedications());
		medicalRecordsInfoDTO.setMedicalRecAllergies(medicalRecords.getAllergies());
        return medicalRecordsInfoDTO;
    }
}
