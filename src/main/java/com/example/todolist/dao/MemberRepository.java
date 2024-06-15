package com.example.todolist.dao;


import com.example.todolist.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

    boolean existsByUserId(String userId);

    MemberEntity getByUserId(String userId);

    @Transactional
    long deleteByUserId(String userId);

}
