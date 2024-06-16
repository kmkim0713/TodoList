package com.example.todolist.service;


import com.example.todolist.dao.UserRepository;
import com.example.todolist.dao.TodoRepository;
import com.example.todolist.dto.TodoLatestSearchResponseDto;
import com.example.todolist.dto.TodoRegistDto;
import com.example.todolist.dto.TodoLatestSearchDto;
import com.example.todolist.dto.TodoRegistResponseDto;
import com.example.todolist.entity.UserEntity;
import com.example.todolist.entity.TodoEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository){
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;

    }

    public TodoRegistResponseDto regist(TodoRegistDto todoRegistDto){

        UserEntity userEntity = userRepository
                .findById(todoRegistDto.getUserIdx())
                .orElseThrow(() -> new IllegalArgumentException("해당 memberId를 가진 회원이 없습니다."));

        TodoEntity todoEntity = todoRepository.save
                (TodoEntity.builder()
                    .content(todoRegistDto.getContent())
                    .status(todoRegistDto.getStatus())
                    .userIdx(userEntity) // 회원 정보 설정
                    .build());

        TodoRegistResponseDto todoRegistResponseDto = TodoRegistResponseDto.builder()
                .todoIdx(todoEntity.getTodoIdx())
                .userIdx(todoEntity.getUserIdx().getUserIdx())
                .status(todoEntity.getStatus())
                .content(todoEntity.getContent())
                .createdAt(todoEntity.getCreatedAt())
                .updatedAt(todoEntity.getUpdatedAt())
                .build();


        return todoRegistResponseDto;

    }

    public TodoLatestSearchResponseDto searchLatest(TodoLatestSearchDto todoLatestSearchDto) {

        TodoEntity todoEntity = (todoRepository
                .findByUserIdx(todoLatestSearchDto.getUserIdx(), PageRequest.of(0, 1))).get(0);

        TodoLatestSearchResponseDto todoLatestSearchResponseDto =
                TodoLatestSearchResponseDto.builder()
                        .todoIdx(todoEntity.getTodoIdx())
                        .userIdx(todoEntity.getUserIdx().getUserIdx())
                        .status(todoEntity.getStatus())
                        .content(todoEntity.getContent())
                        .createdAt(todoEntity.getCreatedAt())
                        .updatedAt(todoEntity.getUpdatedAt())
                        .build();

        return todoLatestSearchResponseDto;
    }

    public List<TodoLatestSearchResponseDto> searchList(TodoLatestSearchDto todoLatestSearchDto, int pageSize) {

        List<TodoEntity> todoEntities = todoRepository
                .findByUserIdx(todoLatestSearchDto.getUserIdx(), PageRequest.of(0, pageSize));

        return todoEntities.stream().map(
                todoEntity -> {
                    return TodoLatestSearchResponseDto.builder()
                            .todoIdx(todoEntity.getTodoIdx())
                            .userIdx(todoEntity.getUserIdx().getUserIdx())
                            .status(todoEntity.getStatus())
                            .content(todoEntity.getContent())
                            .createdAt(todoEntity.getCreatedAt())
                            .updatedAt(todoEntity.getUpdatedAt())
                            .build();
                }).collect(Collectors.toList());

    }
}
