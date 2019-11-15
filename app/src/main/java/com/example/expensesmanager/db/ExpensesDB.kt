package com.example.expensesmanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Expense::class], version = 3, exportSchema = false)
abstract class ExpensesDB : RoomDatabase(){

    abstract fun expenseDao() : ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: ExpensesDB? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ExpensesDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpensesDB::class.java,
                    "expenses_database"
                )
                    .addCallback(ExpenseDBCallback(scope))
//                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }


        private class ExpenseDBCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.expenseDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(expenseDao: ExpenseDao) {
            expenseDao.deleteAll()
            expenseDao.insert(Expense(amount =  60f, spent = true, time = 1500f))
            expenseDao.insert(Expense(amount =  60f, spent = true, time = 1500f))
        }
    }
}