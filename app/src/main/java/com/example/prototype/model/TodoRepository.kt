package com.example.prototype.model

import com.example.prototype.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoRepository { //where we keep business logic and api calls

    //Function to fetch todos using retrofit
    fun fetchTodo(onResult:(List<Todo>?) -> Unit ){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val todos = RetrofitInstance.api.getTodo() // returns the fetched todos via the callback
                onResult(todos)
                println(todos)
            } catch (e: Exception) {
                onResult(null)
            }
        }
    }

}