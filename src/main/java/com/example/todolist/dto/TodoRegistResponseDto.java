package com.example.todolist.dto;


import com.example.todolist.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoRegistResponseDto {

    private Long todoIdx;
    private long userIdx;
    private String status;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public TodoRegistResponseDto(Long todoIdx, long userIdx, String status, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.todoIdx = todoIdx;
        this.userIdx = userIdx;
        this.status = status;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
