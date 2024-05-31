package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDataTransferObject {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "id는 필수 항목입니다.")
    private String CustomerId;
    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    private String CustomPassword;
    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
    private String CustomPasswordCheck;
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String CustomerName;
    @NotEmpty(message = "전화번호는 필수항목입니다.")
    private String PhoneNumber;
    @NotEmpty(message = "이메일은 필수항목입니다.")
    private String Email;
}
