package com.example.PersonalExpense.controller;

import com.example.PersonalExpense.dto.ExpenseRequest;
import com.example.PersonalExpense.dto.ExpenseResponse;
import com.example.PersonalExpense.service.ExpenseService;
import com.example.PersonalExpense.service.Impl.ExpenseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    private static final Logger log = LoggerFactory.getLogger(ExpenseServiceImpl.class);

    @PostMapping("/create")
    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody ExpenseRequest expenseRequest){
        return ResponseEntity.ok(expenseService.createExpense(expenseRequest));
    }

    @GetMapping("all")
    public ResponseEntity<List<ExpenseResponse>> getAllExpense(){
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpenseResponse>> getExpenseByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(expenseService.getExpenseByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponse> updateExpense(@PathVariable Long id, @RequestBody ExpenseResponse expenseResponse){
        return ResponseEntity.ok(expenseService.updateExpense(id,expenseResponse));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Delete Expense Successfully!");
    }


}
