package ma.abdex.conferenceservice.feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KeynoteDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;
}

