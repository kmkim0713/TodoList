package com.example.todolist.controller;

import com.example.todolist.dto.UserJoinDto;
import com.example.todolist.dto.UserLoginDto;
import com.example.todolist.entity.UserEntity;
import com.example.todolist.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<UserEntity> joinMember(@Valid @RequestBody UserJoinDto userJoinDto){
        return ResponseEntity.ok(userService.checkIdDuplication(userJoinDto));
    }


    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginDto userLoginDto) {
        boolean loginSuccessFlag = userService.login(userLoginDto);

        if (loginSuccessFlag) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }


    // 탈퇴
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody @Valid UserLoginDto userLoginDto) {
        boolean loginSuccessFlag = userService.login(userLoginDto);

        if (loginSuccessFlag) {
            if(userService.withdraw(userLoginDto) > 0){
                return ResponseEntity.ok("탈퇴 성공");
            } else{
                return ResponseEntity.badRequest().body("탈퇴 실패");
            }
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }



}
