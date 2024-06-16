package com.example.todolist.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRegistDto {


    private Long memberId;

    @NotBlank
    private String status;

    @NotBlank
    private String content;
}
