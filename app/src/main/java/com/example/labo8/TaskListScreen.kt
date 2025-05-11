package com.example.labo8

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskListScreen(
    tasks: List<Task>,
    onToggleTask: (Task) -> Unit,
    onDeleteAll: () -> Unit,
    onFabClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "Today",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBFBF9)),
                onDeleteAll = onDeleteAll
            )
        },
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar tarea"
                )
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .padding(padding)
            ) {
                tasks.forEach { task ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = task.description)
                        Button(
                            onClick = { onToggleTask(task) },
                            colors =
                                if (task.isCompleted) {
                                    ButtonDefaults.buttonColors(containerColor = Color(0xffdb4c3e))
                                } else {
                                    ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                                },
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Text(
                                text =
                                    if (task.isCompleted)
                                        "Marcar como completada"
                                    else
                                        "Marcar como pendiente",
                                color =
                                    if (task.isCompleted)
                                        Color.White
                                    else
                                        Color.Black
                            )
                        }
                    }
                }
            }
        }
    )
}
