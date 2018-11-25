package com.example.windows.todolist.cenario.cenario_lista

import org.jetbrains.anko.doAsync
import android.content.Context
import com.example.windows.todolist.database.AppDatabase
import com.example.windows.todolist.entidades.ToDoList
import org.jetbrains.anko.uiThread


class MainActivityPresenter(val view: MainActivityContract.view): MainActivityContract.Presenter {
    override fun onAtualizaLista(context: Context) {

        val todoDao = AppDatabase.getInstance(context).todoDao()
        doAsync {
            val todos = todoDao.getAll() as MutableList<ToDoList>
            uiThread {
                view.exibeLista(todos)
            }

        }
    }

    override fun onDeletaToDo(context: Context, toDoList: ToDoList){

        val todoDao = AppDatabase.getInstance(context).todoDao()
        doAsync {
            todoDao.delete(toDoList)
            uiThread {
                onAtualizaLista(context)
            }

        }
    }
}