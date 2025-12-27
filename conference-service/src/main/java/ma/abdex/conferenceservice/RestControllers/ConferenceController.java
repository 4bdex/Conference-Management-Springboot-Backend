package ma.abdex.conferenceservice.RestControllers;

import ma.abdex.conferenceservice.DTO.ConferenceDTO;
import ma.abdex.conferenceservice.Entities.Conference;
import ma.abdex.conferenceservice.Services.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping
    public ResponseEntity<ConferenceDTO> saveConference(@RequestBody ConferenceDTO conferenceDTO) {
        return ResponseEntity.ok(conferenceService.saveConference(conferenceDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> getConferenceById(@PathVariable Long id) {
        return ResponseEntity.ok(conferenceService.getConferenceById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConferenceDTO>> getConferences() {
        return ResponseEntity.ok(conferenceService.getConferences());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConferenceDTO> updateConference(@PathVariable Long id,
                                                          @RequestBody ConferenceDTO conferenceDTO) {
        return ResponseEntity.ok(conferenceService.updateConference(id, conferenceDTO));
    }
}