package com.example.todolist.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TodoUpdateResponseDto {

    private String status;


    @Builder
    public TodoUpdateResponseDto(String status) {
        this.status = status;
    }
}
