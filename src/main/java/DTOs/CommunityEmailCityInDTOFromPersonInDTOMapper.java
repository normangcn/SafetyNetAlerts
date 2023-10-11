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
@Mapper(componentModel= "sping")
public interface CommunityEmailCityInDTOFromPersonInDTOMapper {
	List<CommunityEmailCityInDTO> personInDTOToCommunityEmailCityInDTO (List<PersonInDTO> sourcePerson);
	default CommunityEmailCityInDTO map(PersonInDTO person) {
		CommunityEmailCityInDTO personInfoDTO = new CommunityEmailCityInDTO();
		personInfoDTO.setPersonCity(person.getCity());
		personInfoDTO.setPersonZipCode(person.getZip());
		personInfoDTO.setPersonEmail(person.getEmail());
        return personInfoDTO;
    }
}
