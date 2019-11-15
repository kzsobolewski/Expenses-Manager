package com.example.expensesmanager.entry

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.expensesmanager.MainPage
import com.example.expensesmanager.R
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.db.ExpenseRepository
import com.example.expensesmanager.db.ExpensesDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddEntryViewModel(application: Application) : AndroidViewModel(application) {

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
