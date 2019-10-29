package com.example.expensesmanager.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao{

    @Query("SELECT * FROM Expense_table")
    fun getAllUsers(): LiveData<List<Expense>>

    @Insert
    fun insertEntry(amount: Double, isSpent: Boolean)

    @Delete
    fun deleteEntry(id: Int)
}