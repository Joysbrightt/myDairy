package africa.semicolon.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Entry {
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String body;
    private LocalDateTime dateRegistered = LocalDateTime.now();


}
