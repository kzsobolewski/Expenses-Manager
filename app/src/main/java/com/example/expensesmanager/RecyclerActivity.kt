package com.example.expensesmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.ui.home.ExpenseListAdapter
import com.example.expensesmanager.ui.home.HomeViewModel

class RecyclerActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val adapter = ExpenseListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        homeViewModel.allExpenses.observe(this, Observer { expenses ->
            expenses?.let{adapter.setExpenses(it)}
        })
    }
}
