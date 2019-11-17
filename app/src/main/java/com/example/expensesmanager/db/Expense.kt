package com.example.expensesmanager.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Expense_table")
data class Expense(
    val amount: Float,
    val spent: Boolean = true,
    val currency: String = "PLN",
    val Company: String? = null,
    val description: String? = null,
    val time: String? = null,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
