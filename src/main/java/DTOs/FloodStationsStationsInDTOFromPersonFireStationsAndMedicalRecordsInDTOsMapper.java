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
	List<FloodStationsStationsInDTO> fireStationsInDTOToFloodStationsStationsInDTO (List<FireStationsInDTO> sourceFireStations);
	default FloodStationsStationsInDTO map(FireStationsInDTO fireStation) {
		FloodStationsStationsInDTO fireStationInfoDTO = new FloodStationsStationsInDTO();
		fireStationInfoDTO.setAddressFirestation(fireStation.getAddress());
		fireStationInfoDTO.setStationNumberFirestation(fireStation.getStation());
        return fireStationInfoDTO;
    }
	
	List<FloodStationsStationsInDTO> personInDTOToFloodStationsStationsInDTO (List<PersonInDTO> sourcePerson);
	default FloodStationsStationsInDTO map(PersonInDTO person) {
		FloodStationsStationsInDTO personInfoDTO = new FloodStationsStationsInDTO();
		personInfoDTO.setPersonFirstName(person.getFirstName());
		personInfoDTO.setPersonLastName(person.getLastName());
		personInfoDTO.setPersonAddress(person.getAddress());
		personInfoDTO.setPersonPhoneNumber(person.getPhone());
        return personInfoDTO;
    }
	List<FloodStationsStationsInDTO> medicalRecordsInDTOToFloodStationsStationsInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FloodStationsStationsInDTO map(MedicalRecordsInDTO medicalRecords) {
		FloodStationsStationsInDTO medicalRecordsInfoDTO = new FloodStationsStationsInDTO();
		medicalRecordsInfoDTO.setMedicalRecFirstName(medicalRecords.getFirstName());
		medicalRecordsInfoDTO.setMedicalRecLastName(medicalRecords.getLastName());
		medicalRecordsInfoDTO.setMedicalRecDOB(medicalRecords.getBirthdate());
		medicalRecordsInfoDTO.setMedicalRecMedication(medicalRecords.getMedications());
		medicalRecordsInfoDTO.setMedicalRecAllergies(medicalRecords.getAllergies());
        return medicalRecordsInfoDTO;
    }
}
