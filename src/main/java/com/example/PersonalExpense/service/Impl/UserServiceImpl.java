package com.example.PersonalExpense.service.Impl;

import com.example.PersonalExpense.dto.UserRequest;
import com.example.PersonalExpense.dto.UserResponse;
import com.example.PersonalExpense.model.User;
import com.example.PersonalExpense.repository.UserRepository;
import com.example.PersonalExpense.service.UserService;
import com.example.PersonalExpense.service.handler.UserServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserServiceHandler userServiceHandler;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserServiceHandler::mapToUserResponse)
                .toList();
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userServiceHandler.mapToUser(userRequest);
        userRepository.save(user);
        return UserServiceHandler.mapToUserResponse(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return UserServiceHandler.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        if (userRequest.getPassword() != null && !userRequest.getPassword().isBlank()) {
            user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword())); // Directly encode
        }
        User updatedUser = userRepository.save(user);
        return UserServiceHandler.mapToUserResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
