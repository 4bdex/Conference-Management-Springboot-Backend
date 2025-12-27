package ma.abdex.conferenceservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.abdex.conferenceservice.Entities.ConferenceType;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConferenceDTO {
    private Long id;
    private String title;
    private ConferenceType type;
    private LocalDate date;
    private Integer duration;
    private Integer enrolledCount;
    private Double score;
    private Long keynoteId;
    private List<ReviewDTO> reviews;
}

