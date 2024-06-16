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
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity memberId;

    @Column(nullable = false, name = "status")
    private String status;

    @Column(nullable = false, name = "content")
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public TodoEntity(String status, String content, MemberEntity memberId){
        this.status = status;
        this.content = content;
        this.memberId = memberId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
