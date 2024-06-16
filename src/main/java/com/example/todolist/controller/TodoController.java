package com.example.todolist.controller;


import com.example.todolist.dto.*;
import com.example.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 작성
    @PostMapping("/regist")
    public ResponseEntity<TodoRegistResponseDto> todoRegist(@RequestBody TodoRegistDto todoRegistDto){
        return ResponseEntity.ok(todoService.regist(todoRegistDto));
    }

    // 유저의 최근 게시물 1건 조회
    @PostMapping("/search/latest")
    public ResponseEntity<TodoLatestSearchResponseDto> todoSearchLatest(@RequestBody TodoLatestSearchDto todoLatestSearchDto){
        return ResponseEntity.ok(todoService.searchLatest(todoLatestSearchDto));
    }

    // 유저의 최근 게시물 10건 조회
    @PostMapping("/search/list")
    public ResponseEntity<List<TodoLatestSearchResponseDto>> todoSearchList(@RequestBody TodoLatestSearchDto todoLatestSearchDto){
        return ResponseEntity.ok(todoService.searchList(todoLatestSearchDto, 10));
    }

    // 상태변경
    @PostMapping("/update")
    public ResponseEntity<String> todoUpdateStatus(@RequestBody TodoUpdateDto todoUpdateDto){

        if(todoService.updateStatus(todoUpdateDto)){
            return ResponseEntity.ok("수정 완료");
        }
        return ResponseEntity.badRequest().body("수정 실패");
    }





}
