package com.example.expensesmanager.ui.home

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.db.ExpenseRepository
import com.example.expensesmanager.db.ExpensesDB
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseRepository
    val allExpenses: LiveData<List<Expense>>

    init {
        val expenseDao = ExpensesDB.getDatabase(application, viewModelScope).expenseDao()
        repository = ExpenseRepository(expenseDao)
        allExpenses = repository.allExpenses

    }

}