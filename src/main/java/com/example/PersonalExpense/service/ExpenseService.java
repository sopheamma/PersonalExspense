package com.example.PersonalExpense.service;

import com.example.PersonalExpense.dto.ExpenseRequest;
import com.example.PersonalExpense.dto.ExpenseResponse;

import java.util.List;

public interface ExpenseService {
   public ExpenseResponse createExpense(ExpenseRequest expenseRequest);

   public List<ExpenseResponse> getAllExpense();

   public ExpenseResponse getExpenseById(Long id);

   public ExpenseResponse updateExpense(Long id, ExpenseResponse expenseResponse);

   public void deleteExpense(Long id);

   public List<ExpenseResponse> getExpenseByUserId(Long userId);
}
