package com.sukhdmi.reminderapi.service;

import com.sukhdmi.reminderapi.entity.User;
import com.sukhdmi.reminderapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> readAll(){
        return userRepository.findAll();
    }
    public User readById(Long user_id){
        return userRepository.findById(user_id).orElseThrow(() ->
                new RuntimeException("User not found - " + user_id));
    }
}
