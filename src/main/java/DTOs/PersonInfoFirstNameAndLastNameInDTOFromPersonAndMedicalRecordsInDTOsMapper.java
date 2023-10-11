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
public interface PersonInfoFirstNameAndLastNameInDTOFromPersonAndMedicalRecordsInDTOsMapper {
	List<PersonInfoFirstNameAndLastNameInDTO> personInDTOToPersonInfoFirstNameAndLastNameInDTO (List<PersonInDTO> sourcePerson);
	default PersonInfoFirstNameAndLastNameInDTO map(PersonInDTO person) {
		PersonInfoFirstNameAndLastNameInDTO personInfoDTO = new PersonInfoFirstNameAndLastNameInDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonEmail(person.getEmail());
        return personInfoDTO;
    }
	List<PersonInfoFirstNameAndLastNameInDTO> medicalRecordsInDTOToPersonInfoFirstNameAndLastNameInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default PersonInfoFirstNameAndLastNameInDTO map(MedicalRecordsInDTO medicalRecords) {
		PersonInfoFirstNameAndLastNameInDTO medicalRecordsInfoDTO = new PersonInfoFirstNameAndLastNameInDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
		medicalRecordsInfoDTO.setMedicalRecMedication(medicalRecords.getMedications());
		medicalRecordsInfoDTO.setMedicalRecAllergies(medicalRecords.getAllergies());
        return medicalRecordsInfoDTO;
    }
}
