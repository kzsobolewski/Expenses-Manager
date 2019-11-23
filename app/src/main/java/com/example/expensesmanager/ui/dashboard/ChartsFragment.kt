package com.example.expensesmanager.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        val pieCategoryChart: PieChart = activity!!.findViewById(R.id.category_chart)
        pieCategoryChart.apply {
            isRotationEnabled = true
            holeRadius = 10f
            setTransparentCircleAlpha(0)
            val yData = ArrayList<PieEntry>()
            yData.add(PieEntry(44f, "A"))
            yData.add(PieEntry(22f, "B"))
            yData.add(PieEntry(11f, "C"))
            val dataSet = PieDataSet(yData,"set")

            dataSet.colors = arrayListOf(Color.RED, Color.BLUE, Color.GREEN)
            data = PieData(dataSet)

            invalidate()
        }
    }
}