package com.nelkinda.training;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER("Dinner", 5000),
    BREAKFAST("Breakfast", 1000),
    CAR_RENTAL("Car Rental", Integer.MAX_VALUE);

    private final String expenseName;
    private final int amountLimit;

    ExpenseType(String expenseName, int amountLimit) {
        this.expenseName = expenseName;
        this.amountLimit = amountLimit;
    }

    public int getAmountLimit() {
        return amountLimit;
    }

    public String getExpenseName() {
        return expenseName;
    }
}

class Expense {
    ExpenseType type;
    int amount;

    String getExpenseName() {
        return type.getExpenseName();
    }

    boolean isOverLimit() {
        return amount > type.getAmountLimit();
    }
}

public class ExpenseReport {
    public void printReport(List<Expense> expenses) {
        printReport(expenses, new Date());
    }

    public void printReport(List<Expense> expenses, Date date) {
        int total = 0;
        int mealExpenses =  0;

        System.out.println("Expenses " + date);

        for (Expense expense : expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
                mealExpenses += expense.amount;
            }

            String mealOverExpensesMarker = expense.isOverLimit() ? "X" : " ";

            System.out.println(expense.getExpenseName() + "\t" + expense.amount + "\t" + mealOverExpensesMarker);

            total += expense.amount;
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

}
