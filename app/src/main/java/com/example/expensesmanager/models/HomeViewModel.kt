package com.example.expensesmanager.models

import android.app.Application
import androidx.lifecycle.*
import com.example.expensesmanager.database.Expense
import com.example.expensesmanager.database.ExpenseRepository
import com.example.expensesmanager.database.ExpensesDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseRepository
    val allExpenses: LiveData<List<Expense>>

    init {
        val expenseDao = ExpensesDB.getDatabase(application, viewModelScope).expenseDao()
        repository = ExpenseRepository(expenseDao)
        allExpenses = repository.allExpenses
    }

    fun delete(expense: Expense) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.delete(expense)
        }
    }

}