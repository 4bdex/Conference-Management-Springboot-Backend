package ma.abdex.keynoteservice.RestControllers;

import ma.abdex.keynoteservice.DTO.KeynoteDTO;
import ma.abdex.keynoteservice.Entities.Keynote;
import ma.abdex.keynoteservice.Services.KeynoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeynoteController {
    private final KeynoteService keynoteService;


    public KeynoteController(KeynoteService keynoteService) {
        this.keynoteService = keynoteService;
    }

    @PostMapping("/keynotes")
    public ResponseEntity<Keynote> saveKeynote(@RequestBody KeynoteDTO keynoteDTO){
        return ResponseEntity.ok(keynoteService.save(keynoteDTO));
    }
    @GetMapping("/keynotes/{id}")
    public ResponseEntity<KeynoteDTO> getKeynoteById(@PathVariable Long id){
        return ResponseEntity.ok(keynoteService.getKeynoteById(id));
    }
    @GetMapping("/keynotes")
    public ResponseEntity<List<KeynoteDTO>> getKeynotes(){
        return ResponseEntity.ok(keynoteService.getKeynotes());
    }

    @DeleteMapping("/keynotes/{id}")
    public ResponseEntity<Void> deleteKeynote(@PathVariable Long id){
        keynoteService.deleteKeynote(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/keynotes/{id}")
    public ResponseEntity<Keynote> updateKeynote(@PathVariable Long id, @RequestBody KeynoteDTO keynoteDTO){
        return ResponseEntity.ok(keynoteService.updateKeynote(id, keynoteDTO));
    }


}
