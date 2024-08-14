package com.example.prototype.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.prototype.model.Todo
import com.example.prototype.model.TodoRepository

class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    //Mutable state to hold the list of todos
    val todos = mutableStateOf<List<Todo>>(emptyList())

    fun loadTodos(){
        todoRepository.fetchTodo { result ->
            result?.let {
                todos.value = it
            }
        }
    }

}