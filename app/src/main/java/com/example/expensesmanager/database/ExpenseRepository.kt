package com.example.expensesmanager.database

import androidx.lifecycle.LiveData


class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val allExpenses: LiveData<List<Expense>> = expenseDao.getAll()

    suspend fun insert(expense: Expense){
        expenseDao.insert(expense)
    }

    suspend fun delete(expense: Expense){
        expenseDao.delete(expense)
    }

    suspend fun deleteAll(){
        expenseDao.deleteAll()
    }
}
