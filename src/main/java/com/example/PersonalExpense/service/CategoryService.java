package com.example.PersonalExpense.service;

import com.example.PersonalExpense.dto.CategoryRequest;
import com.example.PersonalExpense.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
   public CategoryResponse createCategory(CategoryRequest categoryRequest);

   public List<CategoryResponse> getAllCategory();

   public CategoryResponse getCategoryById(Long id);

   public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);

   public void deleteCategory(Long id);
}
