package com.example.expensesmanager.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "Expense_table")
data class Expense(
    @PrimaryKey
    val id: Int,
    val amount: Double,
    val spent: Boolean,
    val time: Float
)