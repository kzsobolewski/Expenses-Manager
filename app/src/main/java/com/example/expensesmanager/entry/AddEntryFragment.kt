package com.example.expensesmanager.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
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
        val amountTextView = activity!!.findViewById<EditText>(R.id.addEntry_amount)
//        val spentSwitch= activity?.findViewById<Switch>(R.id.addEntry_spent)?.isActivated ?: true
        addButton.setOnClickListener {
            if (amountTextView.text.toString().trim().isNotEmpty() ||
                amountTextView.text.toString().trim().isNotBlank()
            ) {
                viewModel.insert(
                    Expense(
                        amount = amountTextView.text.toString().toFloat(),
                        spent = true,
                        time = TiviTypeConverters.fromOffsetDateTime(OffsetDateTime.now())
                    )
                ).isCompleted.apply {
                    navController.navigate(R.id.action_addEntryFragment_to_bottomNavBarFragment)
                }
            }
        }
    }


}
