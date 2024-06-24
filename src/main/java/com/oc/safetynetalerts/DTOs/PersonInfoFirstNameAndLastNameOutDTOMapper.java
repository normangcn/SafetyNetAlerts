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
public interface PersonInfoFirstNameAndLastNameOutDTOMapper {
	List<PersonInfoFirstNameAndLastNameOutDTO> personInDTOToPersonInfoFirstNameAndLastNameInDTO (List<PersonInDTO> sourcePerson);
	default PersonInfoFirstNameAndLastNameOutDTO map(PersonInDTO person) {
		PersonInfoFirstNameAndLastNameOutDTO personInfoDTO = new PersonInfoFirstNameAndLastNameOutDTO();
        return personInfoDTO;
    }
	List<PersonInfoFirstNameAndLastNameOutDTO> medicalRecordsInDTOToPersonInfoFirstNameAndLastNameInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default PersonInfoFirstNameAndLastNameOutDTO map(MedicalRecordsInDTO medicalRecords) {
		PersonInfoFirstNameAndLastNameOutDTO medicalRecordsInfoDTO = new PersonInfoFirstNameAndLastNameOutDTO();
        return medicalRecordsInfoDTO;
    }
}
