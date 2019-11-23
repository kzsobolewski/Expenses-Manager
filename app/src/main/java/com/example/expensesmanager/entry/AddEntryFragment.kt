package com.example.expensesmanager.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.expensesmanager.R
import com.example.expensesmanager.db.Expense
import com.example.expensesmanager.formatter.TiviTypeConverters
import kotlinx.android.synthetic.main.fragment_add_entry.*
import java.time.OffsetDateTime

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
        addButton = activity!!.findViewById(R.id.addEntry_button)
        addButton.setOnClickListener {
            if (addEntry_amount.text.toString().trim().isNotEmpty()) {
                viewModel.insert(
                    Expense(
                        amount = addEntry_amount.text.toString().toFloat(),
                        spent = addEntry_spent.isChecked,
                        time = TiviTypeConverters.fromOffsetDateTime(OffsetDateTime.now()),
                        company = addEntry_company.text?.toString(),
                        category = addEntry_category.text?.toString(),
                        currency = addEntry_currency.text?.toString() ?: "PLN",
                        description = addEntry_description.text?.toString()
                    )
                ).isCompleted.apply {
                    navController.navigate(R.id.action_addEntryFragment_to_bottomNavBarFragment)
                }
            } else {
                Toast.makeText(activity!!,R.string.Error_no_string_in_amount, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }


}
