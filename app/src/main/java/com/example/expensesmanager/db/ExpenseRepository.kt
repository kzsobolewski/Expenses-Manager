package com.example.expensesmanager.db

import android.app.Application
import android.os.AsyncTask
import android.os.strictmode.InstanceCountViolation
import androidx.lifecycle.LiveData


class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val allExpenses: LiveData<List<Expense>> = expenseDao.getAll()

    suspend fun insert(expense: Expense){
        expenseDao.insert(expense)
    }

    companion object{
        @Volatile
        private var instance: ExpenseRepository? = null

        fun getInstance(expenseDao: ExpenseDao){
            instance ?: synchronized(this){
                instance ?: ExpenseRepository(expenseDao).also {instance = it
                }
            }
        }

    }
}