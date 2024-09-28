package com.learn.spring.learning.repository;

import com.learn.spring.learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
