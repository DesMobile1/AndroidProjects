package com.example.windows.todolist

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class ToDoList (var ToDo: String,
                    @PrimaryKey(autoGenerate = true)
                    var id: Int = 0) : Serializable