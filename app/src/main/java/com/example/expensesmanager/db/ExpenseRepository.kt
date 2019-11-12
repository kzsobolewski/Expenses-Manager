package com.example.expensesmanager.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData


class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val allExpenses: LiveData<List<Expense>> = expenseDao.getAll()

    suspend fun insert(expense: Expense){
        expenseDao.insert(expense)
    }

}