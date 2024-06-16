package com.example.todolist.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRegistDto {


    private Long userIdx;

    @NotBlank
    private String status;

    @NotBlank
    private String content;
}
