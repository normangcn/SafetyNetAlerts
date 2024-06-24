/**
 * 
 */
package com.oc.safetynetalerts.DTOs;

import java.util.List;

/**
 * @author gareth
 *
 */
public interface FloodStationsStationsInDTOFromPersonFireStationsAndMedicalRecordsInDTOsMapper {
	List<FloodStationsStationsOutDTO> fireStationsInDTOToFloodStationsStationsInDTO (List<FireStationsInDTO> sourceFireStations);
	default FloodStationsStationsOutDTO map(FireStationsInDTO fireStation) {
		FloodStationsStationsOutDTO fireStationInfoDTO = new FloodStationsStationsOutDTO();
        return fireStationInfoDTO;
    }
	
	List<FloodStationsStationsOutDTO> personInDTOToFloodStationsStationsInDTO (List<PersonInDTO> sourcePerson);
	default FloodStationsStationsOutDTO map(PersonInDTO person) {
		FloodStationsStationsOutDTO personInfoDTO = new FloodStationsStationsOutDTO();
        return personInfoDTO;
    }
	List<FloodStationsStationsOutDTO> medicalRecordsInDTOToFloodStationsStationsInDTO (List<MedicalRecordsInDTO> sourceMedicalRecords);
	default FloodStationsStationsOutDTO map(MedicalRecordsInDTO medicalRecords) {
		FloodStationsStationsOutDTO medicalRecordsInfoDTO = new FloodStationsStationsOutDTO();
        return medicalRecordsInfoDTO;
    }
}
