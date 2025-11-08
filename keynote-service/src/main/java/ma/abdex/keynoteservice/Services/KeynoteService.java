package ma.abdex.keynoteservice.Services;

import ma.abdex.keynoteservice.DAO.KeynoteDAO;
import ma.abdex.keynoteservice.DTO.KeynoteDTO;
import ma.abdex.keynoteservice.Entities.Keynote;
import ma.abdex.keynoteservice.Mapper.KeynoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeynoteService {
    private final KeynoteMapper keynoteMapper;
    private final KeynoteDAO keynoteDAO;

    public KeynoteService(KeynoteMapper keynoteMapper, KeynoteDAO keynoteDAO) {
        this.keynoteMapper = keynoteMapper;
        this.keynoteDAO = keynoteDAO;
    }

    public Keynote save(KeynoteDTO keynoteDTO) {
        return keynoteDAO.save(keynoteMapper.toEntity(keynoteDTO));
    }
    public KeynoteDTO getKeynoteById(Long id) {
        Keynote keynote = keynoteDAO.findById(id).orElseThrow(() -> new RuntimeException("Keynote not found"));
        return keynoteMapper.toDto(keynote);
    }
    public List<KeynoteDTO> getKeynotes() {
        List<Keynote> keynotes = keynoteDAO.findAll();
        return keynoteMapper.toDtoList(keynotes);
    }
    public void deleteKeynote(Long id) {
        keynoteDAO.deleteById(id);
    }
}
