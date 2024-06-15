package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "MEMBER")
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 30)
    private String userId;

    private String userPassword;

    @Column(nullable = false, length = 30)
    private String userNickname;

    @Builder
    public MemberEntity(String userId, String userPassword, String userNickname){
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
    }


}
