package com.srini.programing.springmongodb.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.srini.programing.springmongodb.model.Expense;
import com.srini.programing.springmongodb.model.ExpenseCategory;
import com.srini.programing.springmongodb.repository.ExpenseRepository;
import io.mongock.api.annotations.ChangeUnit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@ChangeLog -- depricated
@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id="seedDatabase", author = "srini")
    public void seedDataBase(ExpenseRepository expenseRepository){
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(new Expense("Movie Tickets", ExpenseCategory.ENTERTAINMENT, BigDecimal.valueOf(40)));
        expenseList.add(new Expense("Dinner", ExpenseCategory.RESTAURANT, BigDecimal.valueOf(20)));

        expenseList.add(new Expense("Netflix", ExpenseCategory.ENTERTAINMENT, BigDecimal.valueOf(10)));

        expenseList.add(new Expense("GYM", ExpenseCategory.MISC, BigDecimal.valueOf(30)));
        expenseList.add(new Expense("Internet", ExpenseCategory.UTILITIES, BigDecimal.valueOf(15)));

        expenseRepository.insert(expenseList);


    }
}
