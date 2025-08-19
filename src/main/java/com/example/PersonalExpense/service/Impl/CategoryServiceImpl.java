package com.example.PersonalExpense.service.Impl;

import com.example.PersonalExpense.dto.CategoryRequest;
import com.example.PersonalExpense.dto.CategoryResponse;
import com.example.PersonalExpense.model.Category;
import com.example.PersonalExpense.model.User;
import com.example.PersonalExpense.repository.CategoryRepository;
import com.example.PersonalExpense.repository.UserRepository;
import com.example.PersonalExpense.service.CategoryService;
import com.example.PersonalExpense.service.handler.CategoryServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
       User user = userRepository.findById(categoryRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found: "+ categoryRequest.getUserId()));
       Category category = CategoryServiceHandler.mapToCategory(categoryRequest,user);
       categoryRepository.save(category);
        return CategoryServiceHandler.mapToCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.findAll().stream().map(CategoryServiceHandler::mapToCategoryResponse).toList();
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find user id: " + id));
        return CategoryServiceHandler.mapToCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
       Optional<Category> exitC = categoryRepository.findById(id);
       exitC.get().setName(categoryRequest.getName());
       Category updateCategory = categoryRepository.save(exitC.get());
        return CategoryServiceHandler.mapToCategoryResponse(updateCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }


}
