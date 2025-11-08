package ma.abdex.keynoteservice;

import ma.abdex.keynoteservice.DTO.KeynoteDTO;
import ma.abdex.keynoteservice.Services.KeynoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(KeynoteService keynoteService){
        return args -> {
            for (int i = 0; i < 10; i++) {
                KeynoteDTO keynoteDTO = new KeynoteDTO();
                keynoteDTO.setFirstName("John");
                keynoteDTO.setLastName("Doe");
                keynoteDTO.setFunction("keynote");
                keynoteDTO.setEmail("Jhon@email.com");
                keynoteService.save(keynoteDTO);
            }
        };
    }

}
