package com.example.windows.todolist.cenario.cenario_cadastro

import android.content.Context
import com.example.windows.todolist.database.AppDatabase
import com.example.windows.todolist.database.ToDoDao
import com.example.windows.todolist.entidades.ToDoList
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Main2ActivityPresenter(val view: Main2ActivityContract.view): Main2ActivityContract.Presenter {

    override  fun onSalvaToDo(context: Context, todo: ToDoList) {
        val todoDao: ToDoDao = AppDatabase.getInstance(context).todoDao()
        doAsync {
            todoDao.insert(todo!!)

            uiThread {
                view.SalvoComSucesso()
            }
        }
    }
}