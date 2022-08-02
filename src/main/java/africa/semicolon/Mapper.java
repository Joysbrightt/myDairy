package africa.semicolon;

import africa.semicolon.Exceptions.DiaryUserDoesntExistException;
import africa.semicolon.data.model.Diary;
import africa.semicolon.data.repositories.DiaryRepository;
import africa.semicolon.dtos.DairyRegisterResponse.DiaryUserRegisterResponse;
import africa.semicolon.dtos.DairyRegisterResponse.LoginUserDiaryResponse;
import africa.semicolon.dtos.DiaryUserRegisterRequest.DiaryUserRegisterRequest;
import africa.semicolon.dtos.DiaryUserRegisterRequest.LoginUserDiaryRequest;
import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;

@Slf4j
public class Mapper {

    private static DiaryRepository diaryRepository;
    public static DiaryUserRegisterResponse map(Diary savedDiaryUser, DiaryUserRegisterResponse response){
       DiaryUserRegisterResponse diaryUserRegisterResponse = new DiaryUserRegisterResponse();
        diaryUserRegisterResponse.setName(savedDiaryUser.getName());
        diaryUserRegisterResponse.setMessage("Registered successfully");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE, dd/MM/yy, hh/mm/ss, a");
        diaryUserRegisterResponse.setTimeWritten(dateTimeFormatter.format(savedDiaryUser.getTimeWritten()));
        log.info("mappedResponse-->{}", diaryUserRegisterResponse);
        return diaryUserRegisterResponse;
    }

    public static void map(DiaryUserRegisterRequest request, Diary diaryUser) {
        diaryUser.setName(request.getName());
        if (!diaryUser.getName().equals(request.getName()))throw new DiaryUserDoesntExistException("diary user already existed");
        diaryUser.setPassword(request.getPassword());
    }

    public static void map(Diary savedDiaryUser, LoginUserDiaryRequest request) {
        savedDiaryUser = diaryRepository.findByName(request.getName());
        if (!savedDiaryUser.getName().equals(request.getName()))throw new RuntimeException("diary user not found");
        savedDiaryUser = diaryRepository.findByPassword(request.getPassword());
        LoginUserDiaryResponse loginUserDiaryResponse = new LoginUserDiaryResponse();
        if (savedDiaryUser.getPassword().equals(request.getPassword())){
            loginUserDiaryResponse.setWelcomeMessage("Welcome back" +savedDiaryUser.getName());
        } else throw new RuntimeException("incorrect password");

    }
}
