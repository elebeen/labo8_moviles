package com.example.labo8

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
    onFabClick: () -> Unit,
    onEdit: (Task) -> Unit,
    deleteTask: (Int) -> Unit,
    uncompletedTasksCount: Int = 0
) {
    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier.fillMaxWidth(),
                onDeleteAll = onDeleteAll,
                titleContent = {
                    Column {
                        Text(
                            text = "Today",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = if (uncompletedTasksCount == 0)
                                "Estás al día"
                            else
                                "Tareas pendientes: $uncompletedTasksCount",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
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
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(tasks) { task ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .padding(horizontal = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFDFDFD))
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            // Descripción de la tarea
                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.fillMaxWidth()
                            )

                            // Línea divisoria
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                thickness = 1.dp,
                                color = Color(0xFFDDDDDD)
                            )

                            // Botones de acción
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Button(
                                    onClick = { onToggleTask(task) },
                                    colors = if (task.isCompleted) {
                                        ButtonDefaults.buttonColors(containerColor = Color(0xffdb4c3e))
                                    } else {
                                        ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                                    }
                                ) {
                                    Text(
                                        text = if (task.isCompleted) "Completada" else "Pendiente",
                                        color = if (task.isCompleted) Color.White else Color.Black
                                    )
                                }

                                IconButton(onClick = { onEdit(task) } ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Editar tarea",
                                        tint = Color(0xFFFFC107)
                                    )
                                }

                                IconButton(onClick = { deleteTask(task.id) }) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Eliminar tarea",
                                        tint = Color.Red
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
