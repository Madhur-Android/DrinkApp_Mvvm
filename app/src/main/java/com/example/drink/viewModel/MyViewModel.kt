package com.example.drink.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.drink.MyRepository
import com.example.drink.model.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(private val repository: MyRepository) : ViewModel() {
    private val _userData = MutableLiveData<List<Drink>>()
        val userData: LiveData<List<Drink>> get() = _userData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchData(s: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = repository.fetchData(s)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _userData.value = response.body()?.drinks ?: emptyList()
                    } else {
                        _error.value = "Error: ${response.code()}"
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _error.value = "Error: ${e.message}"
                }
            }
        }
    }
}