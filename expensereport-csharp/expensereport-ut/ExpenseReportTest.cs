using System;
using System.Collections.Generic;
using System.IO;
using expensereport_csharp;
using NUnit.Framework;

namespace Tests;

public class Tests
{

    [Test]
    public void report()
    {
        var consoleSpy = new StringWriter();
        Console.SetOut(consoleSpy);
        var report = new ExpenseReport();
        var expenses = new List<Expense>
        {
            new(ExpenseType.DINNER, 5000),
            new(ExpenseType.DINNER, 5001),
            new(ExpenseType.BREAKFAST, 1000),
            new(ExpenseType.BREAKFAST, 1001),
            new(ExpenseType.CAR_RENTAL, Int32.MaxValue),
        };
        
        report.PrintReport(expenses, DateTime.MinValue);
            
        Assert.AreEqual(@"Expenses 1/1/0001 12:00:00AM
Dinner	5000	 
Dinner	5001	X
Breakfast	1000	 
Breakfast	1001	X
Car Rental	2147483647	 
Meal expenses: 12002
Total expenses: -2147471647
", consoleSpy.ToString());
    }
}