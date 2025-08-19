package com.example.PersonalExpense.service.handler;

import com.example.PersonalExpense.dto.CategoryRequest;
import com.example.PersonalExpense.dto.CategoryResponse;
import com.example.PersonalExpense.dto.UserRequest;
import com.example.PersonalExpense.model.Category;
import com.example.PersonalExpense.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CategoryServiceHandler {

    public static CategoryResponse mapToCategoryResponse (Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .userId(category.getUser().getId())
                .create_at(category.getCreated_at())
                .build();
    }


    public static Category mapToCategory (CategoryRequest categoryRequest,User user){
        return Category.builder()
                .name(categoryRequest.getName())
                .user(user)
                .created_at(LocalDateTime.now())
                .build();
    }
}
