package com.example.PersonalExpense.service;

import com.example.PersonalExpense.dto.UserRequest;
import com.example.PersonalExpense.dto.UserResponse;

import java.util.List;

public interface UserService {
   public List<UserResponse> getAllUser();

   public UserResponse createUser(UserRequest userRequest);

   public UserResponse getUserById(Long id);

   public UserResponse updateUser(Long id, UserRequest userRequest);
}
