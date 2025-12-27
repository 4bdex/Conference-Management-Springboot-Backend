package ma.abdex.conferenceservice.DAO;

import ma.abdex.conferenceservice.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long> {
    List<Review> findByConferenceId(Long conferenceId);
}

