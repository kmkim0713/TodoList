package com.example.todolist.service;


import com.example.todolist.dao.MemberRepository;
import com.example.todolist.dto.MemberJoinDto;
import com.example.todolist.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void joinMember(MemberJoinDto memberJoinDto){

        MemberEntity member = MemberEntity.builder()
                .id(memberJoinDto.getId())
                .pwd(memberJoinDto.getPwd())
                .nickname(memberJoinDto.getNickname())
                .build();

        memberRepository.save(member);
    }

}
