package com.example.PersonalExpense.service.handler;

import com.example.PersonalExpense.dto.UserRequest;
import com.example.PersonalExpense.dto.UserResponse;
import com.example.PersonalExpense.model.User;
import com.example.PersonalExpense.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHandler {
    public static UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User mapToUser(UserRequest userRequest){
        return User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }
}
