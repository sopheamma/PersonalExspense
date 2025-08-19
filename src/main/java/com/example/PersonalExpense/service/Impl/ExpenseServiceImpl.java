package com.example.PersonalExpense.service.Impl;

import com.example.PersonalExpense.dto.ExpenseRequest;
import com.example.PersonalExpense.dto.ExpenseResponse;
import com.example.PersonalExpense.model.Category;
import com.example.PersonalExpense.model.Expense;
import com.example.PersonalExpense.model.User;
import com.example.PersonalExpense.repository.CategoryRepository;
import com.example.PersonalExpense.repository.ExpenseRepository;
import com.example.PersonalExpense.repository.UserRepository;
import com.example.PersonalExpense.service.ExpenseService;
import com.example.PersonalExpense.service.handler.ExpenseServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public ExpenseResponse createExpense(ExpenseRequest expenseRequest) {
        Category category = categoryRepository.findById(expenseRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found with id: " + expenseRequest.getCategoryId()));
        User user = userRepository.findById(expenseRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found with id: " + expenseRequest.getUserId()));
        Expense expense = ExpenseServiceHandler.maptoExpense(expenseRequest,user,category);
        expenseRepository.save(expense);

        return ExpenseServiceHandler.mapToExpenseResponse(expense);
    }

    @Override
    public List<ExpenseResponse> getAllExpense() {
        return expenseRepository.findAll().stream().map(ExpenseServiceHandler::mapToExpenseResponse).toList();
    }

    @Override
    public ExpenseResponse getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("expense not found with id: " + id));

        return ExpenseServiceHandler.mapToExpenseResponse(expense);
    }

    @Override
    public ExpenseResponse updateExpense(Long id, ExpenseResponse expenseResponse) {
        Expense exitE = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("expense not found with id: " + id));


        exitE.setAmount(expenseResponse.getAmount());
        exitE.setDescription(expenseResponse.getDescription());
        exitE.setDate(expenseResponse.getExpenseDate());


        if(expenseResponse.getCategoryId() != null){
            Category category = categoryRepository.findById(expenseResponse.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not fount with id: " + expenseResponse.getCategoryId()));
            exitE.setCategory(category);
        }
        Expense updateExpense = expenseRepository.save(exitE);
        return ExpenseServiceHandler.mapToExpenseResponse(updateExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
