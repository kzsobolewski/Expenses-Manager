package com.example.expensesmanager.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Expense_table")
data class Expense(
    val amount: Float = 0f,
    val spent: Boolean = true,
    val currency: String = "PLN",
    val company: String? = null,
    val description: String? = null,
    val time: String? = null,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
