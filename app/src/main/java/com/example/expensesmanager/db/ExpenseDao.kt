package com.example.expensesmanager.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao{

    @Query("SELECT * FROM Expense_table")
    fun getAll(): LiveData<List<Expense>>

    @Insert
    fun insert(expense: Expense)

    @Delete
    fun delete(expense: Expense)

    @Query("DELETE FROM Expense_table")
    fun deleteAll()
}