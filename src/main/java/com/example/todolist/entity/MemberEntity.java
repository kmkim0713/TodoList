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
    private String id;

    private String pwd;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Builder
    public MemberEntity(String id, String pwd, String nickname){
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
    }


}
