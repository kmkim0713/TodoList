package com.example.todolist.dao;

import com.example.todolist.entity.MemberEntity;
import com.example.todolist.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository  extends JpaRepository<TodoEntity,Long> {


}
