package com.example.expensesmanager.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Expense_table")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Float,
    val spent: Boolean,
    val time: String? = null
)
