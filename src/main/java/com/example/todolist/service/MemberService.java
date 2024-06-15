package com.example.todolist.service;


import com.example.todolist.config.BCryptPwdEncoder;
import com.example.todolist.dao.MemberRepository;
import com.example.todolist.dto.MemberJoinDto;
import com.example.todolist.dto.MemberLoginDto;
import com.example.todolist.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    private BCryptPwdEncoder bCryptPwdEncoder;

    public MemberService(MemberRepository memberRepository, BCryptPwdEncoder bCryptPwdEncoder){

        this.memberRepository = memberRepository;
        this.bCryptPwdEncoder = bCryptPwdEncoder;
    }

    public MemberEntity join(MemberJoinDto memberJoinDto){

        MemberEntity member = MemberEntity.builder()
                .userId(memberJoinDto.getUserId())
                .userPassword(bCryptPwdEncoder.encode(memberJoinDto.getUserPassword()))
                .userNickname(memberJoinDto.getUserNickname())
                .build();

        return memberRepository.save(member);
    }


    public MemberEntity checkIdDuplication(MemberJoinDto memberJoinDto) {
        // ID 중복 체크
        if (memberRepository.existsByUserId(memberJoinDto.getUserId())) {
            throw new RuntimeException("이미 사용중인 ID입니다.");
        }

        return join(memberJoinDto);
    }

    public boolean login(MemberLoginDto memberLoginDto) {

        MemberEntity member = memberRepository.getByUserId(memberLoginDto.getUserId());
        return bCryptPwdEncoder.matches(memberLoginDto.getUserPassword(), member.getUserPassword());

    }

    public long withdraw(MemberLoginDto memberLoginDto) {

        return memberRepository.deleteByUserId(memberLoginDto.getUserId());
    }
}
