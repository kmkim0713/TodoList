package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdateDto {

    @NotBlank
    private Long userIdx;

    @NotBlank
    private Long todoIdx;

    @NotBlank
    private String status;

    @NotBlank
    private String content;

}
