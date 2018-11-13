package com.example.windows.todolist.cenario.cenario_cadastro

import android.content.Context
import com.example.windows.todolist.entidades.ToDoList

interface Main2ActivityContract {

    interface view{
        fun SalvoComSucesso()
    }

    interface Presenter{
        fun onSalvaToDo(context: Context, todo: ToDoList)
    }
}