package com.example.PersonalExpense.repository;

import com.example.PersonalExpense.model.Category;
import com.example.PersonalExpense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Optional<Expense> findByCategoryId(Long CategoryId);
}
