package com.srini.programing.springmongodb.service;

import com.srini.programing.springmongodb.model.Expense;
import com.srini.programing.springmongodb.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;
    public  void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find Expense by ID %s", expense.getId())));
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpanseName(expense.getExpanseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
            return expenseRepository.findByName(name)
                    .orElseThrow(()->new RuntimeException(
                            String.format("Cannot find Expense by name %s", name)));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
