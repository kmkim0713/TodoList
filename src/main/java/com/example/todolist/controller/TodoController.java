package com.example.todolist.controller;


import com.example.todolist.dto.TodoRegistDto;
import com.example.todolist.dto.TodoSearchDto;
import com.example.todolist.entity.TodoEntity;
import com.example.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 작성
    @PostMapping("/regist")
    public ResponseEntity<String> todoRegist(@RequestBody TodoRegistDto todoRegistDto){

        todoService.regist(todoRegistDto);
        return null;

    }

    // 단건 조회
    @PostMapping("/search")
    public ResponseEntity<TodoEntity> todoSearch(@RequestBody TodoSearchDto todoSearchDto){

        return ResponseEntity.ok(todoService.search(todoSearchDto));
    }


    // 수정


    // 목록 조회

    // 상태변경

}
