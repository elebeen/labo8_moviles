package com.example.labo8

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    var currentScreen by remember { mutableStateOf("list") }
    val tasks by viewModel.tasks.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var newTaskDescription by remember { mutableStateOf("") }
    var taskBeingEdited by remember { mutableStateOf<Task?>(null) }

    when (currentScreen) {
        "list" -> TaskListScreen(
            tasks = tasks,
            onToggleTask = { viewModel.toggleTaskCompletion(it) },
            onDeleteAll = {
                coroutineScope.launch {
                    viewModel.deleteAllTasks()
                }
            },
            onFabClick = { currentScreen = "add" },
            onEdit = { task ->
                taskBeingEdited = task
                newTaskDescription = task.description
                currentScreen = "edit"
            },
            deleteTask = { id ->
                coroutineScope.launch {
                    viewModel.deleteTask(id)
                }
            },
            uncompletedTasksCount = tasks.count { !it.isCompleted }
        )
        "add" -> AddTaskScreen(
            taskDescription = newTaskDescription,
            onDescriptionChange = { newTaskDescription = it },
            onDeleteAll = { coroutineScope.launch { viewModel.deleteAllTasks() } },
            onAddTask = {
                if (newTaskDescription.isNotEmpty()) {
                    viewModel.addTask(newTaskDescription)
                    newTaskDescription = ""
                    currentScreen = "list"
                }
            },
            onBack = { currentScreen = "list" }
        )
        "edit" -> taskBeingEdited?.let { task ->
            EditTaskScreen(
                taskDescription = newTaskDescription,
                onDescriptionChange = { newTaskDescription = it },
                onUpdateTask = {
                    coroutineScope.launch {
                        viewModel.updateTask(task.id, newTaskDescription, task.isCompleted)
                        newTaskDescription = ""
                        taskBeingEdited = null
                        currentScreen = "list"
                    }
                },
                onBack = { currentScreen = "list" }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    titleContent: @Composable () -> Unit,
    onDeleteAll: () -> Unit,
) {
    TopAppBar(
        title = titleContent,
        actions = {
            IconButton(onClick = onDeleteAll) {
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar todas las tareas",
                    tint = Color.Red
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    // Recuerda que no debes ejecutar código suspendido directamente en Preview
    val viewModel = remember { FakeTaskViewModel() }

    // Usamos LaunchedEffect para simular carga inicial si es necesario
    LaunchedEffect(Unit) {
        // Nada aquí por ahora; en preview, no se necesita recargar.
    }

    TaskScreen(viewModel = viewModel)
}