package com.sukhdmi.reminderapi.controller;

import com.sukhdmi.reminderapi.entity.User;
import com.sukhdmi.reminderapi.repository.UserRepository;
import com.sukhdmi.reminderapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> readAll(){
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }
}
