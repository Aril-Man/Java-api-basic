package com.learn.spring.learning.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.learn.spring.learning.dto.UserDto;
import com.learn.spring.learning.entity.User;
import com.learn.spring.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.addUser(user);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "00",
                "status", "Success",
                "message" , "Successfully Add User"
        ));
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "00",
                "status", "Success",
                "message" , "Successfully Update User"
        ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "00",
                "status", "Success",
                "message" , "Successfully Delete User"
        ));
    }

    @PutMapping("/update-name/{id}")
    public ResponseEntity<Object> updateNameUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        userService.updateName(id, userDto);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "00",
                "status", "Success",
                "message" , "Successfully Update Name User"
        ));
    }
}
