package com.example.labo8

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditTaskScreen(
    onDescriptionChange: (String) -> Unit,
    onUpdateTask: () -> Unit,
    onBack: () -> Unit,
    taskDescription: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Editar tarea", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = taskDescription,
            onValueChange = onDescriptionChange,
            label = { Text("Descripción de la tarea") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = onUpdateTask, modifier = Modifier.weight(1f)) {
                Text("Actualizar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onBack, modifier = Modifier.weight(1f)) {
                Text("Cancelar")
            }
        }
    }
}
