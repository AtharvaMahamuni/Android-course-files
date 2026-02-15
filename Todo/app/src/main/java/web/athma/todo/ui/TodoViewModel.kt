package web.athma.todo.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {
    private val _todoTextState =  mutableStateOf("")
    val todoTextState: State<String> = _todoTextState

    // Fake data
    private val _fakeTodos = mutableStateOf(listOf(
        "Buy milk",
        "Learn MVVM",
        "Build todo app"
    ))
    val fakeTodos: State<List<String>> = _fakeTodos

    fun updateText(todoText: String) {
        _todoTextState.value = todoText
    }

    fun addTodo() {
        _fakeTodos.value += _todoTextState.value
    }
}