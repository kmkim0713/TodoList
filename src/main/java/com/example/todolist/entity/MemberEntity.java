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
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 30, name="user_id")
    private String userId;

    @Column(nullable = false, name="user_password")
    private String userPassword;

    @Column(nullable = false, length = 30, name="user_nickname")
    private String userNickname;

    @Builder
    public MemberEntity(String userId, String userPassword, String userNickname){
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
    }


}
