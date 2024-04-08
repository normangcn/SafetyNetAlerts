/**
 * 
 */
package DTOs;

import java.util.List;

import org.mapstruct.Mapper;

import com.oc.safetynetalerts.model.FireStation;
import com.oc.safetynetalerts.model.MedicalRecord;
import com.oc.safetynetalerts.model.Person;

/**
 * @author gareth
 *
 */
@Mapper(componentModel= "spring")
public interface FireStationNumberOutDTOMapper {
	List<FirestationStationNumberOutDTO> fireStationsInDTOToFirestationStationNumberInDTO (List<FireStation> sourceFireStations);
	default FirestationStationNumberOutDTO map(FireStation fireStation) {
		FirestationStationNumberOutDTO fireStationInfoDTO = new FirestationStationNumberOutDTO();
        return fireStationInfoDTO;
    }
	
	List<FirestationStationNumberOutDTO> personToFirestationStationNumberOutDTO (List<Person> sourcePerson);
	default FirestationStationNumberOutDTO map(Person person) {
		FirestationStationNumberOutDTO personInfoDTO = new FirestationStationNumberOutDTO();
        return personInfoDTO;
    }
	List<FirestationStationNumberOutDTO> medicalRecordsToFirestationStationNumberOutDTO (List<MedicalRecord> sourceMedicalRecord);
	default FirestationStationNumberOutDTO map(MedicalRecordsInDTO medicalRecord) {
		FirestationStationNumberOutDTO medicalRecordsInfoDTO = new FirestationStationNumberOutDTO();
        return medicalRecordsInfoDTO;
    }
}
