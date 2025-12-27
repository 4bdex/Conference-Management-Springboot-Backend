package ma.abdex.conferenceservice.DAO;

import ma.abdex.conferenceservice.Entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceDAO extends JpaRepository<Conference, Long> {

}

