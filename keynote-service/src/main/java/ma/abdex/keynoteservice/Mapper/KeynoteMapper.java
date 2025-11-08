package ma.abdex.keynoteservice.Mapper;

import ma.abdex.keynoteservice.DTO.KeynoteDTO;
import ma.abdex.keynoteservice.Entities.Keynote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KeynoteMapper {
    KeynoteDTO toDto(Keynote keynote);
    Keynote toEntity(KeynoteDTO keynoteDTO);
    List<KeynoteDTO> toDtoList(List<Keynote> keynotes);
}
