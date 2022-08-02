package africa.semicolon.service;

import africa.semicolon.Mapper;
import africa.semicolon.data.model.Diary;
import africa.semicolon.data.model.Entry;
import africa.semicolon.data.repositories.DiaryRepository;
import africa.semicolon.dtos.DairyRegisterResponse.LoginUserDiaryResponse;
import africa.semicolon.dtos.DiaryUserRegisterRequest.DiaryUserRegisterRequest;
import africa.semicolon.dtos.DairyRegisterResponse.DiaryUserRegisterResponse;
import africa.semicolon.dtos.DiaryUserRegisterRequest.LoginUserDiaryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DiaryUserServiceImpl implements  DiaryUserService{

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryUserServiceImpl( DiaryRepository diaryRepository){
        this.diaryRepository = diaryRepository;
    }

//    public DiaryUserServiceImpl(@Autowired DiaryEntryRespository diaryEntryRespository){
//    }
    @Override
    public DiaryUserRegisterResponse diaryUser(DiaryUserRegisterRequest request) {
        Diary diaryUser = new Diary();
        Mapper.map(request, diaryUser);
       Diary savedDiaryUser = diaryRepository.save(diaryUser);
       log.info("saved diary-->{}", savedDiaryUser);
       Entry entry = new Entry(request.getTitle(), request.getBody());

       DiaryUserRegisterResponse diaryUserRegisterResponse = new DiaryUserRegisterResponse();
            var response =Mapper.map(savedDiaryUser, diaryUserRegisterResponse);
            log.info("-->{}", diaryUserRegisterResponse);
        return response;

    }

    @Override
    public LoginUserDiaryResponse diaryUserLogin(LoginUserDiaryRequest request ) {
        Diary savedDiaryUser = diaryRepository.findByName(request.getName());
        Mapper.map(savedDiaryUser, request);
        LoginUserDiaryResponse loginUserDiaryResponse = new LoginUserDiaryResponse();
        return loginUserDiaryResponse;
    }

    @Override
    public Diary Entry(Entry entry) {
        return null;
    }


}
