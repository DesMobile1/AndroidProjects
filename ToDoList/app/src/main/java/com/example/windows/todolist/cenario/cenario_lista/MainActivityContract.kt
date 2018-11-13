package com.example.windows.todolist.cenario.cenario_lista

import android.content.Context
import com.example.windows.todolist.entidades.ToDoList

interface MainActivityContract {

    interface view{
        fun exibeLista(lista: MutableList<ToDoList>)

    }

    interface Presenter{
        fun onAtualizaLista(context: Context)
        fun onDeletaToDo()
    }
}