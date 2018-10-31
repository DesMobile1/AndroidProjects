package com.example.windows.todolist

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.todo_item_list.*
import android.content.Intent
import org.jetbrains.anko.activityUiThreadWithContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.ArrayList

class MainActivity : AppCompatActivity(){

    var todos : MutableList<ToDoList> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton2.setOnClickListener() {
            val cadastrarToDo = Intent(this, Main2Activity::class.java)
            startActivityForResult(cadastrarToDo, 1)
        }


    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable("lista", todos as ArrayList<String>)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null)
            todos = savedInstanceState.getSerializable("lista") as MutableList<ToDoList>
    }

    fun carregaLista() {
        val todoDao = AppDatabase.getInstance(this).todoDao()
        doAsync {
            todos = todoDao.getAll() as MutableList<ToDoList>

            activityUiThreadWithContext {
                val adapter = ToDoAdapter(this, todos)

                //configura o clique em cada item do RecyclerView
                adapter.setOnItemClickListener { indexToDoListClicado ->
                    val editaToDoList = Intent(this, Main2Activity::class.java)
                    editaToDoList.putExtra(Main2Activity.TODO, todos.get(indexToDoListClicado))
                    startActivity(editaToDoList)
                }


                val layoutManager = LinearLayoutManager(this)

                rvToDo.adapter = adapter
                rvToDo.layoutManager = layoutManager
            }
        }
    }
}
