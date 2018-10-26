package com.example.windows.todolist

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(){

    var todos : MutableList<ToDoList> = mutableListOf()
    var indexToDoListClicado: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener(){
            val cadastrarToDo = Intent(this,Main2Activity::class.java)
            startActivityForResult(cadastrarToDo, 1)
        }

    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val todo: ToDoList? = data?.getSerializableExtra(Main2Activity.TODO) as ToDoList
            //caso algum item tenha sido clicado seus dados são alterados, caso não adiciona um novo
            if (todo != null) {
                if (indexToDoListClicado >= 0) {
                    todos.set(indexToDoListClicado, todo)
                    indexToDoListClicado = -1
                } else {
                    todos.add(todo)
                }
            }
        }
    }


    fun carregaLista() {
        val adapter = ToDoAdapter(this, todos)

        //configura o clique em cada item do RecyclerView
        adapter.setOnItemClickListener { todo, indexToDoListClicado ->
            this.indexToDoListClicado = indexToDoListClicado
            val editaContatinho = Intent(this, Main2Activity::class.java)
            editaContatinho.putExtra(Main2Activity.TODO, todo)
            this.startActivityForResult(editaContatinho, 1)
        }

        val layoutManager = LinearLayoutManager(this)

        rvToDo.adapter = adapter
        rvToDo.layoutManager = layoutManager
    }
}
