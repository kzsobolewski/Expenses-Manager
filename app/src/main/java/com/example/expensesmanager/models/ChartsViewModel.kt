package com.example.expensesmanager.models

import android.app.Application
import androidx.lifecycle.*
import com.example.expensesmanager.database.Expense
import com.example.expensesmanager.database.ExpenseRepository
import com.example.expensesmanager.database.ExpensesDB

class ChartsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseRepository
    val allExpenses: LiveData<List<Expense>>


    init {
        val expenseDao = ExpensesDB.getDatabase(application, viewModelScope).expenseDao()
        repository = ExpenseRepository(expenseDao)
        allExpenses = repository.allExpenses
    }
}