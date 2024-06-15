package com.example.todolist.service;


import com.example.todolist.config.BCryptPwdEncoder;
import com.example.todolist.dao.MemberRepository;
import com.example.todolist.dto.MemberJoinDto;
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

    public void joinMember(MemberJoinDto memberJoinDto){

        MemberEntity member = MemberEntity.builder()
                .id(memberJoinDto.getId())
                .pwd(bCryptPwdEncoder.encode(memberJoinDto.getPwd()))
                .nickname(memberJoinDto.getNickname())
                .build();

        memberRepository.save(member);
    }

}
