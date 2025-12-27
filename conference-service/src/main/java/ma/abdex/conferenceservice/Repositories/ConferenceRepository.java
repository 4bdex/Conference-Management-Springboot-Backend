package ma.abdex.conferenceservice.Repositories;

import ma.abdex.conferenceservice.Entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
