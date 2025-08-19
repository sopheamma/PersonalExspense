package com.example.PersonalExpense.service.Impl;

import com.example.PersonalExpense.dto.CategoryRequest;
import com.example.PersonalExpense.dto.CategoryResponse;
import com.example.PersonalExpense.model.Category;
import com.example.PersonalExpense.repository.CategoryRepository;
import com.example.PersonalExpense.service.CategoryService;
import com.example.PersonalExpense.service.handler.CategoryServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = CategoryServiceHandler.mapToUser(categoryRequest);
        categoryRepository.save(category);
        return CategoryServiceHandler.mapToCategoryResponse(category);
    }
}
