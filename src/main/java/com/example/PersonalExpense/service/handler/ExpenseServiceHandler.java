package com.example.PersonalExpense.service.handler;

import com.example.PersonalExpense.dto.CategoryResponse;
import com.example.PersonalExpense.dto.ExpenseRequest;
import com.example.PersonalExpense.dto.ExpenseResponse;
import com.example.PersonalExpense.model.Category;
import com.example.PersonalExpense.model.Expense;
import com.example.PersonalExpense.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExpenseServiceHandler {
    public static ExpenseResponse mapToExpenseResponse (Expense expense){
        return ExpenseResponse.builder()
                .id(expense.getId())
                .amount(expense.getAmount())
                .description(expense.getDescription())
                .expenseDate(expense.getDate())
                .categoryId(expense.getCategory().getId())
                .categoryName(expense.getCategory().getName())
                .userId(expense.getUser().getId())
                .username(expense.getUser().getUsername())
                .create_at(expense.getCreate_at())
                .build();
    }

    public static Expense maptoExpense (ExpenseRequest expenseRequest, User user, Category category){
        return Expense.builder()
                .amount(expenseRequest.getAmount())
                .description(expenseRequest.getDescription())
                .date(expenseRequest.getExpenseDate())
                .user(user)
                .category(category)
                .create_at(LocalDateTime.now())
                .build();
    }
}
