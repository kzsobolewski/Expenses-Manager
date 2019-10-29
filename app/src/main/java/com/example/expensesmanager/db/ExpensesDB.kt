package com.example.expensesmanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Expense::class), version = 1)
public abstract class ExpensesDB : RoomDatabase(){

    abstract fun expenseDao() : ExpenseDao

    companion object{
        @Volatile
        private var INSTANCE: ExpensesDB? = null

        fun getDatabase(context: Context): ExpensesDB{
            val tmpInstance = INSTANCE
            if (tmpInstance != null){
                return tmpInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpensesDB::class.java,
                    "Expenses_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}