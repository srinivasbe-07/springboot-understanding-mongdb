package com.srini.programing.springmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Objects;

@Document("expanse")
public class Expense {
    @Id
    private String id;
    @Field(name="name")
    @Indexed(unique = true)
    private String expanseName;
    @Field(name="category")
    private ExpenseCategory expenseCategory;
    @Field(name = "amount")
    private BigDecimal expenseAmount;
    public Expense(){

    }
    public Expense(String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount) {
        this.expanseName = expenseName;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
    }
    public Expense(String id, String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount) {
        this(expenseName, expenseCategory, expenseAmount);
        this.id = id;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) && Objects.equals(expanseName, expense.expanseName) && expenseCategory == expense.expenseCategory && Objects.equals(expenseAmount, expense.expenseAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expanseName, expenseCategory, expenseAmount);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExpanseName(String expanseName) {
        this.expanseName = expanseName;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getId() {
        return id;
    }

    public String getExpanseName() {
        return expanseName;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }
}
