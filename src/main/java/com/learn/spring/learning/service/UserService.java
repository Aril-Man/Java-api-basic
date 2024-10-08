package com.learn.spring.learning.service;

import com.learn.spring.learning.dto.UserDto;
import com.learn.spring.learning.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDto userDto);
}
