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
public interface ChildAlertAddressInDTOFromPersonAndMedicalRecordsInDTOsMapper {
	List<ChildAlertAddressInDTO> personInDTOToChildAlertAddressInDTO (List<PersonInDTO> sourcePerson);
	default ChildAlertAddressInDTO map(PersonInDTO person) {
		ChildAlertAddressInDTO personInfoDTO = new ChildAlertAddressInDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
        return personInfoDTO;
    }
	List<ChildAlertAddressInDTO> medicalRecordsInDTOToChildAlertAddressInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default ChildAlertAddressInDTO map(MedicalRecordsInDTO medicalRecords) {
		ChildAlertAddressInDTO medicalRecordsInfoDTO = new ChildAlertAddressInDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
        return medicalRecordsInfoDTO;
    }
}
