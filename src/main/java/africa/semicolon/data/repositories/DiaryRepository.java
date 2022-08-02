package africa.semicolon.data.repositories;

import africa.semicolon.data.model.Diary;
import africa.semicolon.data.model.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DiaryRepository extends MongoRepository<Diary, String >{
    Diary findByName(String name);

    Diary findByPassword(String password);



}
