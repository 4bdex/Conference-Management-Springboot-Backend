package ma.abdex.conferenceservice;

import ma.abdex.conferenceservice.DTO.ConferenceDTO;
import ma.abdex.conferenceservice.DTO.ReviewDTO;
import ma.abdex.conferenceservice.Entities.ConferenceType;
import ma.abdex.conferenceservice.Services.ConferenceService;
import ma.abdex.conferenceservice.Services.ReviewService;
import ma.abdex.conferenceservice.feign.KeynoteDTO;
import ma.abdex.conferenceservice.feign.KeynoteServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }
    // init with some data
    @Bean
    CommandLineRunner start(KeynoteServiceClient keynoteServiceClient, ConferenceService conferenceService, ReviewService reviewService) {
        return args -> {
            var keynotes = keynoteServiceClient.getKeynotes();
            for (KeynoteDTO keynote : keynotes) {
                ConferenceDTO conferenceDTO = new ConferenceDTO();
                conferenceDTO.setTitle("Conference on " + keynote.getFirstName());
                conferenceDTO.setType(ConferenceType.ACADEMIC);
                conferenceDTO.setKeynoteId(keynote.getId());
                conferenceService.saveConference(conferenceDTO);
            }
            conferenceService.getConferences().forEach(conferenceDTO -> {
                for (int i = 0; i < 3; i++) {
                    // Add some reviews for each conference

                        ReviewDTO reviewDTO = new ReviewDTO();
                        reviewDTO.setText("This is review " + i + " for conference " + conferenceDTO.getTitle());
                        reviewDTO.setStars((int)(Math.random() * 5) + 1);
                        reviewDTO.setConferenceId(conferenceDTO.getId());
                        reviewService.save(reviewDTO);

                }
            });

        };
    }

}
