package africa.semicolon.dtos.DiaryUserRegisterRequest;

import lombok.Data;

@Data
public class DiaryUserRegisterRequest {
    private String name;
    private String password;
    private String title;
    private  String body;
}
