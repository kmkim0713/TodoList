package com.example.todolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinDto {

    private Long memberId;
    private String id;
    private String pwd;
    private String nickname;
}
