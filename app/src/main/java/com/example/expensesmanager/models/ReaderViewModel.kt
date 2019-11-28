package com.example.expensesmanager.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.database.Expense
import com.example.expensesmanager.database.ExpenseRepository
import com.example.expensesmanager.database.ExpensesDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReaderViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseRepository

    init {
        val expenseDao = ExpensesDB.getDatabase(application, viewModelScope).expenseDao()
        repository = ExpenseRepository(expenseDao)
    }

    fun insert(expense: Expense) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insert(expense)
        }
    }
}