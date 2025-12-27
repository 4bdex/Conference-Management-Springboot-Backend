package ma.abdex.conferenceservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service")
public interface KeynoteServiceClient {

    @GetMapping("/keynotes/{id}")
    KeynoteDTO getKeynoteById(@PathVariable Long id);

    @GetMapping("/keynotes")
    KeynoteDTO[] getKeynotes();
}

