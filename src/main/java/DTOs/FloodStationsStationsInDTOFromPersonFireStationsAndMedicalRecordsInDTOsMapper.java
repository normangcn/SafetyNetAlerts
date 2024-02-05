/**
 * 
 */
package DTOs;

import java.util.List;

/**
 * @author gareth
 *
 */
public interface FloodStationsStationsInDTOFromPersonFireStationsAndMedicalRecordsInDTOsMapper {
	List<FloodStationsStationsOutDTO> fireStationsInDTOToFloodStationsStationsInDTO (List<FireStationsInDTO> sourceFireStations);
	default FloodStationsStationsOutDTO map(FireStationsInDTO fireStation) {
		FloodStationsStationsOutDTO fireStationInfoDTO = new FloodStationsStationsOutDTO();
		fireStationInfoDTO.setStationNumberFirestation(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<FloodStationsStationsOutDTO> personInDTOToFloodStationsStationsInDTO (List<PersonInDTO> sourcePerson);
	default FloodStationsStationsOutDTO map(PersonInDTO person) {
		FloodStationsStationsOutDTO personInfoDTO = new FloodStationsStationsOutDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
	List<FloodStationsStationsOutDTO> medicalRecordsInDTOToFloodStationsStationsInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FloodStationsStationsOutDTO map(MedicalRecordsInDTO medicalRecords) {
		FloodStationsStationsOutDTO medicalRecordsInfoDTO = new FloodStationsStationsOutDTO();
		medicalRecordsInfoDTO.setMedicalRecMedication(medicalRecords.getMedications());
		medicalRecordsInfoDTO.setMedicalRecAllergies(medicalRecords.getAllergies());
        return medicalRecordsInfoDTO;
    }
}
