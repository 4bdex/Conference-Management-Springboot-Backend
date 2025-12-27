package ma.abdex.keynoteservice.Repositories;

import ma.abdex.keynoteservice.Entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {

}
