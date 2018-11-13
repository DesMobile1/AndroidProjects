package com.example.windows.todolist.cenario.cenario_lista

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.content.Intent
import com.example.windows.todolist.R
import com.example.windows.todolist.entidades.ToDoList
import com.example.windows.todolist.cenario.cenario_cadastro.Main2Activity
import java.util.ArrayList

class MainActivity : AppCompatActivity(), MainActivityContract.view {

    var todos : MutableList<ToDoList> = mutableListOf()

    val presenter : MainActivityContract.Presenter = MainActivityPresenter(this)

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
        presenter.onAtualizaLista(this)
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

    override fun exibeLista(lista: MutableList<ToDoList>) {
        todos = lista


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
