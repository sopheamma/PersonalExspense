package com.example.PersonalExpense.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseRequest {
    private Long id;
    private double amount;
    private String description;
    private LocalDate expenseDate;
    private LocalDateTime create_at;
    private Long categoryId;

}
