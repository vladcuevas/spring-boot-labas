package com.fsdprogram.demo.controllers.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.fsdprogram.demo.model.User;
import com.querydsl.core.types.Predicate;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>  {
    public List<User> findAll(Predicate predicate);
    Optional<User> findByUserName(String userName);
}