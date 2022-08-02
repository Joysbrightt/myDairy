package africa.semicolon.service;

import africa.semicolon.data.model.Diary;
import africa.semicolon.data.model.Entry;
import africa.semicolon.dtos.DiaryUserRegisterRequest.DiaryUserRegisterRequest;
import africa.semicolon.dtos.DairyRegisterResponse.DiaryUserRegisterResponse;
import africa.semicolon.dtos.DairyRegisterResponse.LoginUserDiaryResponse;
import africa.semicolon.dtos.DiaryUserRegisterRequest.LoginUserDiaryRequest;

import java.util.ArrayList;
import java.util.List;

public interface DiaryUserService {
    DiaryUserRegisterResponse diaryUser(DiaryUserRegisterRequest request);

    LoginUserDiaryResponse diaryUserLogin(LoginUserDiaryRequest request);

    List<Entry> entries = new ArrayList<>();
    Diary Entry (Entry entry);
}
