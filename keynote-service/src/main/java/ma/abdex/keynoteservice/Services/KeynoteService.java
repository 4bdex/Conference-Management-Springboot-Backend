package ma.abdex.keynoteservice.Services;

import ma.abdex.keynoteservice.DAO.KeynoteDAO;
import ma.abdex.keynoteservice.DTO.KeynoteDTO;
import ma.abdex.keynoteservice.Entities.Keynote;
import ma.abdex.keynoteservice.Mapper.KeynoteMapper;
import ma.abdex.keynoteservice.Repositories.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeynoteService {
    private final KeynoteMapper keynoteMapper;
    private final KeynoteDAO keynoteDAO;
    private final KeynoteRepository keynoteRepository;

    public KeynoteService(KeynoteMapper keynoteMapper, KeynoteDAO keynoteDAO, KeynoteRepository keynoteRepository) {
        this.keynoteMapper = keynoteMapper;
        this.keynoteDAO = keynoteDAO;
        this.keynoteRepository = keynoteRepository;
    }

    public Keynote save(KeynoteDTO keynoteDTO) {

        return keynoteRepository.save(keynoteMapper.toEntity(keynoteDTO)
        );
    }
    public KeynoteDTO getKeynoteById(Long id) {
        Keynote keynote = keynoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Keynote not found"));
        return keynoteMapper.toDto(keynote);
    }
    public List<KeynoteDTO> getKeynotes() {
        List<Keynote> keynotes = keynoteRepository.findAll();
        return keynoteMapper.toDtoList(keynotes);
    }
    public void deleteKeynote(Long id) {
        keynoteDAO.deleteById(id);
    }

    public Keynote updateKeynote(Long id, KeynoteDTO keynoteDTO) {
        Keynote existingKeynote = keynoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Keynote not found"));
        existingKeynote.setFirstName(keynoteDTO.getFirstName());
        existingKeynote.setLastName(keynoteDTO.getLastName());
        existingKeynote.setFunction(keynoteDTO.getFunction());
        existingKeynote.setEmail(keynoteDTO.getEmail());
        return keynoteRepository.save(existingKeynote);
    }
}
