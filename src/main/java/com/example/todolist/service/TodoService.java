package com.example.todolist.service;


import com.example.todolist.dao.MemberRepository;
import com.example.todolist.dao.TodoRepository;
import com.example.todolist.dto.TodoRegistDto;
import com.example.todolist.dto.TodoSearchDto;
import com.example.todolist.entity.MemberEntity;
import com.example.todolist.entity.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    public TodoService(TodoRepository todoRepository, MemberRepository memberRepository){
        this.todoRepository = todoRepository;
        this.memberRepository = memberRepository;

    }

    public TodoEntity regist(TodoRegistDto todoRegistDto){

        // 회원 조회
        MemberEntity memberEntity = memberRepository
                .findById(todoRegistDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 memberId를 가진 회원이 없습니다."));

        // TodoEntity 생성
        TodoEntity todoEntity = TodoEntity.builder()
                .content(todoRegistDto.getContent())
                .status(todoRegistDto.getStatus())
                .memberId(memberEntity) // 회원 정보 설정
                .build();

        return todoRepository.save(todoEntity);

    }

    public TodoEntity search(TodoSearchDto todoSearchDto) {

        TodoEntity todoEntity = todoRepository
                .findById(todoSearchDto.getTodoId())
                .orElseThrow(() -> new IllegalArgumentException("해당 todoId를 가진 회원이 없습니다."));

        return todoEntity;
    }
}
