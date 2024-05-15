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
	List<CommunityEmailCityOutDTO> personInDTOToCommunityEmailCityInDTO (List<PersonInDTO> sourcePerson);
	default CommunityEmailCityOutDTO map(PersonInDTO person) {
		CommunityEmailCityOutDTO personInfoDTO = new CommunityEmailCityOutDTO();
        return personInfoDTO;
    }
}
