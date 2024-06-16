package com.example.todolist.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "TODO")
@NoArgsConstructor
public class TodoEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", nullable = false)
    private UserEntity userIdx;

    @Column(nullable = false, name = "status")
    private String status;

    @Column(nullable = false, name = "content")
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public TodoEntity(String status, String content, UserEntity userIdx){
        this.status = status;
        this.content = content;
        this.userIdx = userIdx;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    public boolean validStatus(String changeStatus) {
        // "TO DO" -> "PENDING" -> "IN PROGRESS" -> "DONE"

        if(changeStatus.equals("TODO") || changeStatus.equals("IN PROGRESS") ||
                changeStatus.equals("DONE") || changeStatus.equals("PENDING")){

            if(changeStatus.equals("PENDING") && this.status.equals("TODO")){
                return true;
            }

            if(changeStatus.equals("IN PROGRESS") && this.status.equals("PENDING")){
                return true;
            }

            if(changeStatus.equals("DONE") && this.status.equals("IN PROGRESS")){
                return true;
            }

            // 진행 중 상태에서만 대기 상태 변경
            if (changeStatus.equals("IN PROGRESS") && this.status.equals("PENDING")) {
                return true;
            }

            // 대기 상태에서는 모든 상태 변경 가능
            if (this.status.equals("PENDING")) {
                return true;
            }
        }

        return false;

    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
