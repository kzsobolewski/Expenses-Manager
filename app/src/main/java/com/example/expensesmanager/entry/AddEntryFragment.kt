package com.example.expensesmanager.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.expensesmanager.R
import com.example.expensesmanager.db.Expense
import kotlinx.android.synthetic.main.activity_main_page.*
import kotlinx.android.synthetic.main.fragment_bottom_nav_bar.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
            viewModel.insert(Expense(amount = 69f, spent = true, time = 10f))
            navController.navigate(R.id.action_addEntryFragment_to_bottomNavBarFragment)
        }
    }



}
