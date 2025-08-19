package com.example.PersonalExpense.service.Impl;

import com.example.PersonalExpense.dto.UserRequest;
import com.example.PersonalExpense.dto.UserResponse;
import com.example.PersonalExpense.model.User;
import com.example.PersonalExpense.repository.UserRepository;
import com.example.PersonalExpense.service.UserService;
import com.example.PersonalExpense.service.handler.UserServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUser() {

        return userRepository.findAll().stream().map(UserServiceHandler::mapToUserResponse).toList();
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = UserServiceHandler.mapToUser(userRequest);
        userRepository.save(user);
        return UserServiceHandler.mapToUserResponse(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return UserServiceHandler.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        Optional<User> exitUser = userRepository.findById(id);
        exitUser.get().setUsername(userRequest.getUsername());
        exitUser.get().setEmail(userRequest.getEmail());
        exitUser.get().setPassword(userRequest.getPassword());
        User updateUser = userRepository.save(exitUser.get());
        return UserServiceHandler.mapToUserResponse(updateUser);
    }


}
