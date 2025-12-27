package ma.abdex.conferenceservice.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ConferenceType type; // ACADEMIC or COMMERCIAL

    private LocalDate date;
    private Integer duration; // in minutes
    private Integer enrolledCount;
    private Double score;

    private Long keynoteId; // Reference to keynote service

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}

