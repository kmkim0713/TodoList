package com.example.todolist.dao;

import com.example.todolist.entity.TodoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository  extends JpaRepository<TodoEntity,Long> {

    @Query("SELECT t FROM TodoEntity t WHERE t.userIdx.userIdx = :userIdx ORDER BY t.createdAt DESC")
    List<TodoEntity> findByUserIdx(@Param("userIdx") Long userIdx, Pageable pageable);


    @Query("SELECT t FROM TodoEntity t WHERE t.todoIdx = :todoIdx AND t.userIdx.userIdx = :userIdx")
    TodoEntity findByTodoIdxAndUserIdx(@Param("todoIdx") Long todoIdx, @Param("userIdx") Long userIdx);
}
