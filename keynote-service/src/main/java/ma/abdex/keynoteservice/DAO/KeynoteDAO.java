package ma.abdex.keynoteservice.DAO;

import ma.abdex.keynoteservice.Entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KeynoteDAO extends JpaRepository<Keynote, Long> {

}
