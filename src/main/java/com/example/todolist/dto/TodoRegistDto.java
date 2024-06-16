package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRegistDto {

    @NotBlank
    private Long userIdx;

    @NotBlank
    private String content;
}
