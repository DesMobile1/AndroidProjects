package com.example.windows.todolist.database

import android.arch.persistence.room.*
import com.example.windows.todolist.entidades.ToDoList

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: ToDoList)

    @Query("SELECT * FROM todolist")
    fun getAll(): List<ToDoList>

    @Delete
    fun delete(todo: ToDoList)

    @Query("SELECT * FROM todolist WHERE id = :todoId LIMIT 1")
    fun getToDoList(todoId: Int): ToDoList

    @Query("SELECT * FROM todolist WHERE ToDo like :todoNome")
    fun findByName(todoNome: String): List<ToDoList>
}