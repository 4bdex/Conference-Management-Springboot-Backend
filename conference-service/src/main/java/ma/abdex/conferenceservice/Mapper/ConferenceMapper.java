package ma.abdex.conferenceservice.Mapper;

import ma.abdex.conferenceservice.DTO.ConferenceDTO;
import ma.abdex.conferenceservice.Entities.Conference;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConferenceMapper {
    ConferenceDTO toDto(Conference conference);
    Conference toEntity(ConferenceDTO conferenceDTO);
    List<ConferenceDTO> toDtoList(List<Conference> conferences);
}

