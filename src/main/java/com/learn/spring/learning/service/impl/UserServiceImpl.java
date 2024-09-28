package com.learn.spring.learning.service.impl;

import com.learn.spring.learning.dto.UserDto;
import com.learn.spring.learning.entity.User;
import com.learn.spring.learning.repository.UserRepository;
import com.learn.spring.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository
                    .findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User id " + id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        // Check existing user
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User id" + id));

        user.setId(id);

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        // Check existing user
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));

        userRepository.deleteById(id);
    }

    @Override
    public void updateName(Integer id, UserDto userDto) {
        User users = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));

        users.setName(userDto.getName());

        userRepository.save(users);
    }
}
