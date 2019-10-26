package com.example.expensesmanager.entry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddEntryViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is add entry"
    }
    val text: LiveData<String> = _text
}
