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
public interface ChildAlertAddressOutDTOFromPersonAndMedicalRecordsMapper {
	List<ChildAlertAddressOutDTO> personInDTOToChildAlertAddressInDTO (List<PersonInDTO> sourcePerson);
	default ChildAlertAddressOutDTO map(PersonInDTO person) {
		ChildAlertAddressOutDTO personInfoDTO = new ChildAlertAddressOutDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
        return personInfoDTO;
    }
	List<ChildAlertAddressOutDTO> medicalRecordsInDTOToChildAlertAddressInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default ChildAlertAddressOutDTO map(MedicalRecordsInDTO medicalRecords) {
		ChildAlertAddressOutDTO medicalRecordsInfoDTO = new ChildAlertAddressOutDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
        return medicalRecordsInfoDTO;
    }
}
