package com.example.prototype.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prototype.model.TodoRepository

class TodoViewModelFactory(private val repository: TodoRepository) : ViewModelProvider.Factory { //This works good if I only have one view model that needs dependencies passed in, if you have mutliple different viewmodels can either use a generic factory,
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}