package africa.semicolon.dtos.DairyRegisterResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccessful;
    private Object data;

//    public ApiResponse(boolean b, DiaryUserRegisterResponse diaryResponse) {
//    }
}
