package ma.abdex.conferenceservice.Services;

import ma.abdex.conferenceservice.DAO.ConferenceDAO;
import ma.abdex.conferenceservice.DTO.ConferenceDTO;
import ma.abdex.conferenceservice.Entities.Conference;
import ma.abdex.conferenceservice.Mapper.ConferenceMapper;
import ma.abdex.conferenceservice.Repositories.ConferenceRepository;
import ma.abdex.conferenceservice.feign.KeynoteServiceClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConferenceService {

    private final ConferenceMapper conferenceMapper;
    private final ConferenceDAO conferenceDAO;
    private final KeynoteServiceClient keynoteServiceClient;
    private final ConferenceRepository conferenceRepository;


    public ConferenceService(ConferenceMapper conferenceMapper,
                             ConferenceDAO conferenceDAO,
                             KeynoteServiceClient keynoteServiceClient, ConferenceRepository conferenceRepository) {
        this.conferenceMapper = conferenceMapper;
        this.conferenceDAO = conferenceDAO;
        this.keynoteServiceClient = keynoteServiceClient;
        this.conferenceRepository = conferenceRepository;
    }

    public ConferenceDTO saveConference(ConferenceDTO conferenceDTO) {
        // Verify keynote exists
        if (conferenceDTO.getKeynoteId() != null) {
            keynoteServiceClient.getKeynoteById(conferenceDTO.getKeynoteId());
        }
        Conference conf = conferenceRepository.save(conferenceMapper.toEntity(conferenceDTO));
        return conferenceMapper.toDto(conf);
    }

    public ConferenceDTO getConferenceById(Long id) {
        Conference conf = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));
        return conferenceMapper.toDto(conf);
    }

    public List<ConferenceDTO> getConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        return conferenceMapper.toDtoList(conferences);
    }

    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }

    public ConferenceDTO updateConference(Long id, ConferenceDTO conferenceDTO) {
        Conference existing = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        // Verify keynote exists if it's being changed
        if (conferenceDTO.getKeynoteId() != null && !conferenceDTO.getKeynoteId().equals(existing.getKeynoteId())) {
            keynoteServiceClient.getKeynoteById(conferenceDTO.getKeynoteId());
        }

        existing.setTitle(conferenceDTO.getTitle());
        existing.setType(conferenceDTO.getType());
        existing.setDate(conferenceDTO.getDate());
        existing.setDuration(conferenceDTO.getDuration());
        existing.setEnrolledCount(conferenceDTO.getEnrolledCount());
        existing.setScore(conferenceDTO.getScore());
        existing.setKeynoteId(conferenceDTO.getKeynoteId());

        Conference updated = conferenceRepository.save(existing);
        return conferenceMapper.toDto(updated);
    }
}
