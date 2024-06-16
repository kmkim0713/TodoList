package com.example.todolist.controller;

import com.example.todolist.dto.MemberJoinDto;
import com.example.todolist.dto.MemberLoginDto;
import com.example.todolist.entity.MemberEntity;
import com.example.todolist.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<MemberEntity> joinMember(@Valid @RequestBody MemberJoinDto memberJoinDto){
        return ResponseEntity.ok(memberService.checkIdDuplication(memberJoinDto));
    }


    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid MemberLoginDto memberLoginDto) {
        boolean loginSuccessFlag = memberService.login(memberLoginDto);

        if (loginSuccessFlag) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }


    // 탈퇴
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody @Valid MemberLoginDto memberLoginDto) {
        boolean loginSuccessFlag = memberService.login(memberLoginDto);

        if (loginSuccessFlag) {
            if(memberService.withdraw(memberLoginDto) > 0){
                return ResponseEntity.ok("탈퇴 성공");
            } else{
                return ResponseEntity.badRequest().body("탈퇴 실패");
            }
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }



}
