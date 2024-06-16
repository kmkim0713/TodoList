package com.example.todolist.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWithdrawResponseDto {

    private String status;

    @Builder
    public UserWithdrawResponseDto(String status){
        this.status = status;
    }
}
