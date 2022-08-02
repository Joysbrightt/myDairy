package africa.semicolon.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Diary {
    @DBRef
    private List<Entry> entries;
    @NonNull
    private String name;
    @NonNull
    private String password;
    @Id
    private String id;
    @NonNull
    private int numberOfEntries;

    private LocalDateTime timeWritten = LocalDateTime.now();

}
