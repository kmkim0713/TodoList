package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "TODO_USER")
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name="user_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @Column(nullable = false, length = 30, name="user_id")
    private String userId;

    @Column(nullable = false, name="user_password")
    private String userPassword;

    @Column(nullable = false, length = 30, name="user_nickname")
    private String userNickname;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public UserEntity(String userId, String userPassword, String userNickname) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
