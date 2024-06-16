package com.example.todolist.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDto {

    private String userId;
    private String status;

    @Builder
    public UserLoginResponseDto(String userId, String status){
        this.userId = userId;
        this.status = status;
    }
}
