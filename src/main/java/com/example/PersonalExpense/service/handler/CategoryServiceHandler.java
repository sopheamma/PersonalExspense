package com.example.PersonalExpense.service.handler;

import com.example.PersonalExpense.dto.CategoryRequest;
import com.example.PersonalExpense.dto.CategoryResponse;
import com.example.PersonalExpense.dto.UserRequest;
import com.example.PersonalExpense.model.Category;
import com.example.PersonalExpense.model.User;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceHandler {

    public static CategoryResponse mapToCategoryResponse (Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .create_at(category.getCreated_at())
                .build();
    }

    public static Category mapToUser(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.getName())
                .created_at(categoryRequest.getCreate_at())
                .build();
    }
}
