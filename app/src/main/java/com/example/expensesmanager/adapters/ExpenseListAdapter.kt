package com.example.expensesmanager.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.database.Expense
import com.example.expensesmanager.utils.TiviTypeConverters

class ExpenseListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<ExpenseListAdapter.ExpenseViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var onItemClick: ((Expense) -> Boolean)? = null
    private var expenses = emptyList<Expense>() // cached copy

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return ExpenseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val current = expenses[getInvertedPosition(position)]
        holder.amountItemView.text = String.format("%.2f %s", current.amount, current.currency)
        if (current.spent)
            holder.amountItemView.text = "- " + holder.amountItemView.text
        val dateTime = TiviTypeConverters.toOffsetDateTime(current.time)
        holder.timeItemView.text = dateTime?.toLocalDate().toString()

        holder.amountItemView.setTextColor(
            if(current.spent)
                Color.argb(255,200, 10, 10)
            else
                Color.argb(255,10,200,10)
        )
    }

    internal fun setExpenses(expenses: List<Expense>){
        this.expenses = expenses
        notifyDataSetChanged()
    }

    override fun getItemCount() = expenses.size

    fun getInvertedPosition(position: Int) = itemCount - position - 1



    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val amountItemView : TextView = itemView.findViewById(R.id.recyclerview_item_value)
        val timeItemView : TextView = itemView.findViewById(R.id.recyclerview_item_time)

        init {
            itemView.setOnLongClickListener{
                onItemClick!!.invoke(expenses[getInvertedPosition(adapterPosition)])
            }
        }
    }

}
