package ma.abdex.conferenceservice.Mapper;

import ma.abdex.conferenceservice.DAO.ConferenceDAO;
import ma.abdex.conferenceservice.DTO.ReviewDTO;
import ma.abdex.conferenceservice.Entities.Conference;
import ma.abdex.conferenceservice.Entities.Review;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "conference", source = "conferenceId")
    Review toEntity(ReviewDTO reviewDTO, @Context ConferenceDAO conferenceDAO);

    @Mapping(target = "conferenceId", source = "conference.id")
    ReviewDTO toDto(Review review);

    List<ReviewDTO> toDtoList(List<Review> reviews);

    default Conference mapIdToConference(Long conferenceId, @Context ConferenceDAO conferenceDAO) {
        if (conferenceId == null) {
            return null;
        }
        return conferenceDAO.findById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found with id: " + conferenceId));
    }
}

