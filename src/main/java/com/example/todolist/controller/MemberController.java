package com.example.todolist.controller;

import com.example.todolist.dto.MemberJoinDto;
import com.example.todolist.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<String> joinMember(@RequestBody MemberJoinDto memberJoinDto){

        memberService.joinMember(memberJoinDto);

        return ResponseEntity.ok("회원가입 완료");
    }


    // 로그인


    // 탈퇴




}
