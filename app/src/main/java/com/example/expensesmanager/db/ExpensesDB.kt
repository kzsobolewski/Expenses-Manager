package com.example.expensesmanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Expense::class], version = 1, exportSchema = true)
abstract class ExpensesDB : RoomDatabase(){

    abstract val expenseDao : ExpenseDao

    companion object{
        @Volatile
        private var INSTANCE: ExpensesDB? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ExpensesDB{
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ExpensesDB::class.java,
                        "expenses_database"
                    )
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}