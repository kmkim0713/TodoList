package com.example.todolist.dto;

import com.example.todolist.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoLatestSearchResponseDto {

    private Long todoIdx;
    private Long userIdx;
    private String status;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public TodoLatestSearchResponseDto(Long todoIdx, Long userIdx, String status, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.todoIdx = todoIdx;
        this.userIdx = userIdx;
        this.status = status;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
