package com.example.prototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prototype.model.Todo
import com.example.prototype.model.TodoRepository
import com.example.prototype.viewmodel.TodoViewModel
import com.example.prototype.viewmodel.TodoViewModelFactory

class MainActivity : ComponentActivity() {
    private val todoViewModel: TodoViewModel by viewModels {
        TodoViewModelFactory(TodoRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestCompose(todoViewModel = todoViewModel)
        }
    }
}


@Composable
fun TestCompose(todoViewModel: TodoViewModel) {
    val todos = todoViewModel.todos

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            items(todos.value) { todo ->
                TodoItem(todo)
            }

        }

        Button(
            onClick = { todoViewModel.loadTodos() },
            modifier = Modifier.align(Alignment.BottomCenter).padding(4.dp)
        ) {
            Text(text = "RELEASE THE DATA")
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    Text(text = "${todo.title} : ${todo.completed}")
}