package com.userproject1.UserService.controller;

import com.userproject1.UserService.dto.ResponseDto;
import com.userproject1.UserService.entity.User;
import com.userproject1.UserService.exception.UserNotFoundException;
import com.userproject1.UserService.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
	
    @Autowired
    private final UserService userService = null;

    // Create a user
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get a user by ID with exception handling
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId) {
        try {
            ResponseDto responseDto = userService.getUser(userId);
            return ResponseEntity.ok(responseDto);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}


