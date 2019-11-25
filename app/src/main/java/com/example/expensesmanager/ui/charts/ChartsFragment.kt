package com.example.expensesmanager.ui.charts

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.expensesmanager.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.fragment_charts.*

class ChartsFragment : Fragment() {

    private lateinit var viewModel: ChartsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(ChartsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_charts, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        calculateSpending()
        showChart()
    }

    private fun calculateSpending() {
        var spentSum: Float = 0f
        var earnedSum: Float = 0f
        viewModel.allExpenses.observe(this, Observer { expenses ->
            for(expense in expenses){
                if(expense.spent)
                    spentSum += expense.amount
                else
                    earnedSum += expense.amount
            }
            spent_money_text.text = "Money spent: " + spentSum.toString() + " PLN"
            earned_money_text.text = "Money earned: " + earnedSum.toString() + " PLN"
        })

    }


    private fun showChart() {
        val pieCategoryChart: PieChart = activity!!.findViewById(R.id.category_chart)
        viewModel.allExpenses.observe(this, Observer { expenses ->
            pieCategoryChart.apply {
                isRotationEnabled = true
                holeRadius = 10f
                setTransparentCircleAlpha(0)
                val yData = ArrayList<PieEntry>()
                for(expense in expenses){
                    if(expense.spent)
                        yData.add(PieEntry(expense.amount, expense.company))
                }
                val dataSet = PieDataSet(yData, "set")
                dataSet.colors = arrayListOf(Color.RED, Color.BLUE, Color.GREEN, Color.LTGRAY)
                data = PieData(dataSet)

                invalidate()
        }
        })
    }
}