package com.example.expensesmanager.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.expensesmanager.R
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.formatter.TiviTypeConverters
import java.sql.Date
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class AddEntryFragment : Fragment(){

    private lateinit var viewModel: AddEntryViewModel
    private lateinit var addButton: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(AddEntryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_entry,container,false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val navController = Navigation.findNavController(activity!!, R.id.main_nav_fragment)
        addButton = activity!!.findViewById(R.id.addNewEntryButton)
        addButton.setOnClickListener{
            viewModel.insert(Expense(
                amount = 65f,
                spent = false,
                time = TiviTypeConverters.fromOffsetDateTime(OffsetDateTime.now())
            ))
            navController.navigate(R.id.action_addEntryFragment_to_bottomNavBarFragment)
        }
    }



}
