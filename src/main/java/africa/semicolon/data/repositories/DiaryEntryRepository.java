package africa.semicolon.data.repositories;

import africa.semicolon.data.model.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryEntryRepository extends MongoRepository<Entry, String> {
    Entry findByTitle(String title);

}
