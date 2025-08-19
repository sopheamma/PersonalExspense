package com.example.PersonalExpense.service;

import com.example.PersonalExpense.dto.CategoryRequest;
import com.example.PersonalExpense.dto.CategoryResponse;

public interface CategoryService {
   public CategoryResponse createCategory(CategoryRequest categoryRequest);
}
