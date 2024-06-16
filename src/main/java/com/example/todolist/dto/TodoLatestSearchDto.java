package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoLatestSearchDto {

    @NotBlank
    private Long userIdx;

}
