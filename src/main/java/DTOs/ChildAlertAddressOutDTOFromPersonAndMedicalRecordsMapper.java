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
        return personInfoDTO;
    }
	List<ChildAlertAddressOutDTO> medicalRecordsInDTOToChildAlertAddressInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default ChildAlertAddressOutDTO map(MedicalRecordsInDTO medicalRecords) {
		ChildAlertAddressOutDTO medicalRecordsInfoDTO = new ChildAlertAddressOutDTO();
        return medicalRecordsInfoDTO;
    }
}
