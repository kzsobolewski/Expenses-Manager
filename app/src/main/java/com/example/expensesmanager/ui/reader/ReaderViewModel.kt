package com.example.expensesmanager.ui.reader

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.db.ExpenseRepository
import com.example.expensesmanager.db.ExpensesDB
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