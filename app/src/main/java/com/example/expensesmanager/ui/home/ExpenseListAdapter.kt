package com.example.expensesmanager.ui.home

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.formatter.TiviTypeConverters

class ExpenseListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<ExpenseListAdapter.ExpenseViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var expenses = emptyList<Expense>() // cached copy

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amountItemView : TextView = itemView.findViewById(R.id.recyclerview_item_value)
        val timeItemView : TextView = itemView.findViewById(R.id.recyclerview_item_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return ExpenseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val current = expenses[expenses.size - 1 - position]
        holder.amountItemView.text = current.amount.toString()
        val dateTime = TiviTypeConverters.toOffsetDateTime(current.time)
        holder.timeItemView.text = dateTime?.toLocalDate().toString()

        holder.amountItemView.setTextColor(
            if(current.spent)
                Color.RED
            else
                Color.argb(255,10,255,10)
        )
    }

    internal fun setExpenses(expenses: List<Expense>){
        this.expenses = expenses
        notifyDataSetChanged()
    }

    override fun getItemCount() = expenses.size

}