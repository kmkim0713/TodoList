package com.example.todolist.dao;


import com.example.todolist.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    boolean existsByUserId(String userId);

    UserEntity getByUserId(String userId);

    @Transactional
    long deleteByUserId(String userId);

}
