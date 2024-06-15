package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinDto {

    private Long memberId;

    @NotBlank(message = "ID는 필수 입력 항목입니다.")
    @Size(max = 30, message = "ID는 30자 이하여야 합니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 8, max = 30, message = "비밀번호는 8자에서 30자 사이여야 합니다.")
    private String userPassword;

    @NotBlank(message = "닉네임은 필수 입력 항목입니다.")
    @Size(max = 30, message = "닉네임은 30자 이하여야 합니다.")
    private String userNickname;
}
