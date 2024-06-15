package com.example.todolist.controller;

import com.example.todolist.dto.MemberJoinDto;
import com.example.todolist.dto.MemberLoginDto;
import com.example.todolist.service.MemberService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> joinMember(@Valid @RequestBody MemberJoinDto memberJoinDto){

        memberService.checkIdDuplication(memberJoinDto);

        return ResponseEntity.ok("[ "+ memberJoinDto.getUserId() + " ] 회원가입 완료");
    }


    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid MemberLoginDto memberLoginDto) {
        boolean loginSuccessful = memberService.login(memberLoginDto);

        if (loginSuccessful) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }


    // 탈퇴




}
