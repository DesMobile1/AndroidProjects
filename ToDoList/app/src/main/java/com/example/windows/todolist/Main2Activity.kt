package com.example.windows.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    companion object {
        public const val TODO: String = "ToDo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val todo: ToDoList? = intent.getSerializableExtra(TODO) as ToDoList?
        if(todo != null){
            carregaDados(todo)
        }

    }

    private fun salvaContatinho() {

        val todo = addText.text.toString()

        val abreLista = Intent(this, MainActivity::class.java)
        abreLista.putExtra(TODO, todo)
        setResult(Activity.RESULT_OK, abreLista)
        finish()
    }

    private fun carregaDados(todo: ToDoList) {
        addText.setText(todo.ToDo)
    }
}
