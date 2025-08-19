package com.example.PersonalExpense.service.handler;

import com.example.PersonalExpense.dto.UserRequest;
import com.example.PersonalExpense.dto.UserResponse;
import com.example.PersonalExpense.model.User;
import com.example.PersonalExpense.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class UserServiceHandler {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceHandler(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())// ⚠️ usually don’t expose password in response
                .create_at(user.getCreate_at())
                .build();
    }

    public User mapToUser(UserRequest userRequest){
        return User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword())) // ✅ encode here
                .create_at(LocalDateTime.now())
                .build();
    }
}

