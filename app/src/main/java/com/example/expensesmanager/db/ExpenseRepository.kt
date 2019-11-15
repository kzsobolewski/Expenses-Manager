package com.example.expensesmanager.db

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import android.os.strictmode.InstanceCountViolation
import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope


class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val allExpenses: LiveData<List<Expense>> = expenseDao.getAll()

    suspend fun insert(expense: Expense){
        expenseDao.insert(expense)
    }
}