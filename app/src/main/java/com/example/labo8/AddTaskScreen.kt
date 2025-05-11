package com.example.labo8

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddTaskScreen(
    taskDescription: String,
    onDescriptionChange: (String) -> Unit,
    onAddTask: () -> Unit,
    onDeleteAll: () -> Unit,
    onBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier.fillMaxWidth(),
                onDeleteAll = onDeleteAll,
                titleContent = {
                    Column {
                        Text(
                            text = "Añadir tarea",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Añade todas tus tareas",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
            )
        },
        bottomBar = { BottomBar() },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(innerPadding)
            ) {
                TextField(
                    value = taskDescription,
                    onValueChange = onDescriptionChange,
                    label = { Text("Descripción de la tarea") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onAddTask,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Agregar")
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cancelar")
                }
            }
        }
    )
}
