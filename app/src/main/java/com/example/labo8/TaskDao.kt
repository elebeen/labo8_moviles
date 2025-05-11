package com.example.labo8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Query("select * from tasks")
    suspend fun getAllTasks(): List<Task>

    // Insertar una nueva tarea
    @Insert
    suspend fun insertTask(task: Task)

    // Marcar una tarea como completada o no completada
    @Update
    suspend fun updateTask(task: Task)

    // Eliminar todas las tareas
    @Query("delete from tasks")
    suspend fun deleteAllTasks()

    // Eliminar una tarea concreta
    @Query("delete from tasks where id = :id")
    suspend fun deleteTask(id: Int)

    // Actualizar una tarea concreta
    @Query("update tasks set description = :description, is_completed = :isCompleted where id = :id")
    suspend fun updateTask(id: Int, description: String, isCompleted: Boolean)
}