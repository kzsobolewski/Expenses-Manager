package com.example.expensesmanager.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.expensesmanager.R

class AddEntryFragment : Fragment() {

    private lateinit var viewModel: AddEntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(viewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_entry,container)
        return root
    }


}
