package africa.semicolon.controller;

import africa.semicolon.Exceptions.DiaryUserDoesntExistException;
import africa.semicolon.dtos.DairyRegisterResponse.ApiResponse;
import africa.semicolon.dtos.DairyRegisterResponse.DiaryUserRegisterResponse;
import africa.semicolon.dtos.DairyRegisterResponse.LoginUserDiaryResponse;
import africa.semicolon.dtos.DiaryUserRegisterRequest.DiaryUserRegisterRequest;
import africa.semicolon.dtos.DiaryUserRegisterRequest.LoginUserDiaryRequest;
import africa.semicolon.service.DiaryUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DiaryAppUserController {

    private final DiaryUserService diaryUserService;

    public DiaryAppUserController(@Autowired DiaryUserService diaryUserService) {
        this.diaryUserService = diaryUserService;
    }

    @PostMapping("/diaryUser")
    public ResponseEntity<?> register(@RequestBody DiaryUserRegisterRequest request) {
        try {

            DiaryUserRegisterResponse diaryUserRegisterResponse = diaryUserService.diaryUser(request);
            log.info("here-->{}", diaryUserRegisterResponse);
            ApiResponse apiResponse = new ApiResponse(true, diaryUserRegisterResponse);

            log.info("apiresponse-->{}", apiResponse);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

        } catch (DiaryUserDoesntExistException diaryUserDoesntExistException) {
            log.error("error-->");
            ApiResponse apiResponse = new ApiResponse(false, diaryUserDoesntExistException.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("User/Login")
    public ResponseEntity<?> login(@RequestBody LoginUserDiaryRequest request, HttpStatus HttpInputMessage) {
        try {
            LoginUserDiaryResponse loginDiaryUser = diaryUserService.diaryUserLogin( request);
            diaryUserService.diaryUserLogin(request);
            ApiResponse apiResponse = new ApiResponse(true, diaryUserService);
            return new ResponseEntity<>(apiResponse, HttpInputMessage);
        } catch (DiaryUserDoesntExistException diaryUserDoesntExistException){
            ApiResponse apiResponse = new ApiResponse(false, diaryUserDoesntExistException.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }

    }
}


