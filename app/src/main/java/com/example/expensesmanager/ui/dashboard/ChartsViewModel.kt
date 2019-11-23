package com.example.expensesmanager.ui.dashboard

import android.app.Application
import androidx.lifecycle.*
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.db.ExpenseRepository
import com.example.expensesmanager.db.ExpensesDB

class ChartsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseRepository
    val allExpenses: LiveData<List<Expense>>

    init {
        val expenseDao = ExpensesDB.getDatabase(application, viewModelScope).expenseDao()
        repository = ExpenseRepository(expenseDao)
        allExpenses = repository.allExpenses
    }
}