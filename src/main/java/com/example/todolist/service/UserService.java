package com.example.todolist.service;


import com.example.todolist.config.BCryptPwdEncoder;
import com.example.todolist.dao.UserRepository;
import com.example.todolist.dto.UserJoinDto;
import com.example.todolist.dto.UserLoginDto;
import com.example.todolist.dto.UserLoginResponseDto;
import com.example.todolist.dto.UserWithdrawResponseDto;
import com.example.todolist.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPwdEncoder bCryptPwdEncoder;

    public UserService(UserRepository userRepository, BCryptPwdEncoder bCryptPwdEncoder){

        this.userRepository = userRepository;
        this.bCryptPwdEncoder = bCryptPwdEncoder;
    }

    public UserEntity join(UserJoinDto userJoinDto){

        UserEntity member = UserEntity.builder()
                .userId(userJoinDto.getUserId())
                .userPassword(bCryptPwdEncoder.encode(userJoinDto.getUserPassword()))
                .userNickname(userJoinDto.getUserNickname())
                .build();

        return userRepository.save(member);
    }


    public UserEntity checkIdDuplication(UserJoinDto userJoinDto) {
        // ID 중복 체크
        if (userRepository.existsByUserId(userJoinDto.getUserId())) {
            throw new RuntimeException("이미 사용중인 ID입니다.");
        }

        return join(userJoinDto);
    }

    public UserLoginResponseDto login(UserLoginDto userLoginDto) {

        UserEntity user = userRepository.getByUserId(userLoginDto.getUserId());

        if(user == null){
            return UserLoginResponseDto.builder()
                    .status("fail")
                    .build();
        }

        if(bCryptPwdEncoder.matches(userLoginDto.getUserPassword(), user.getUserPassword())){
            return UserLoginResponseDto.builder()
                    .userId(user.getUserId())
                    .status("success")
                    .build();
        } else {
            return UserLoginResponseDto.builder()
                    .userId(user.getUserId())
                    .status("fail")
                    .build();
        }
    }

    public UserWithdrawResponseDto withdraw(UserLoginDto userLoginDto) {

        Long result = userRepository.deleteByUserId(userLoginDto.getUserId());

        if(result > 0){
            return UserWithdrawResponseDto.builder()
                    .status("success")
                    .build();
        }

        return UserWithdrawResponseDto.builder()
                .status("fail")
                .build();
    }
}
