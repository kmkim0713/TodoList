package com.example.todolist.controller;

import com.example.todolist.dto.UserJoinDto;
import com.example.todolist.dto.UserLoginDto;
import com.example.todolist.dto.UserLoginResponseDto;
import com.example.todolist.dto.UserWithdrawResponseDto;
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
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody @Valid UserLoginDto userLoginDto) {
        UserLoginResponseDto userLoginResponseDto = userService.login(userLoginDto);

        if (userLoginResponseDto.getStatus().equals("success")) {
            return ResponseEntity.ok(userLoginResponseDto);
        } else {
            return ResponseEntity.badRequest().body(userLoginResponseDto);
        }
    }


    // 탈퇴
    @PostMapping("/withdraw")
    public ResponseEntity<UserWithdrawResponseDto> withdraw(@RequestBody @Valid UserLoginDto userLoginDto) {
        UserLoginResponseDto userLoginResponseDto = userService.login(userLoginDto);

        if (userLoginResponseDto.getStatus().equals("success")) {

            UserWithdrawResponseDto userWithdrawResponseDto = userService.withdraw(userLoginDto);
            if(userWithdrawResponseDto.getStatus().equals("success")){
                return ResponseEntity.ok(userWithdrawResponseDto);
            } else {
                return ResponseEntity.badRequest().body(userWithdrawResponseDto);
            }
        } else {
            UserWithdrawResponseDto userWithdrawResponseDto = UserWithdrawResponseDto.builder().status("login fail").build();
            return ResponseEntity.badRequest().body(userWithdrawResponseDto);
        }
    }



}
