package ma.abdex.conferenceservice.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String text;

    @Column(name = "stars")
    private Integer stars; // 1 to 5

    @ManyToOne
    @JoinColumn(name = "conference_id", nullable = false)
    private Conference conference;
}

