package com.example.windows.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Main2Activity : AppCompatActivity() {

    companion object {
        public const val TODO: String = "ToDo"
    }

    var todo: ToDoList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        todo = intent.getSerializableExtra(TODO) as ToDoList?
        if(todo != null){
            carregaDados()
        }

        addButton.setOnClickListener{
            salvaToDo()
        }
    }

    private fun salvaToDo() {

        if (todo == null) {
            todo = ToDoList(addText.text.toString())
        } else {
            todo?.ToDo = addText.text.toString()
        }

        val todoDao: ToDoDao = AppDatabase.getInstance(this).todoDao()
        doAsync {
            todoDao.insert(todo!!)

            uiThread {
                finish()
            }
        }

        val abreLista = Intent(this, MainActivity::class.java)
        abreLista.putExtra(TODO, todo)
        setResult(Activity.RESULT_OK, abreLista)
        finish()
    }

    private fun carregaDados() {
        addText.setText(todo?.ToDo)
    }
}
