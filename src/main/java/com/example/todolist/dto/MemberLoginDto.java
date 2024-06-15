package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginDto {

    @NotBlank(message = "ID는 필수 입력 항목입니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String userPassword;
}
