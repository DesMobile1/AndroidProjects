package com.example.windows.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD:ToDoList/app/src/main/java/com/example/windows/todolist/cenario/cenario_cadastro/Main2Activity.kt
import android.widget.Toast
import com.example.windows.todolist.cenario.cenario_lista.MainActivity
import com.example.windows.todolist.R
import com.example.windows.todolist.entidades.ToDoList
<<<<<<< HEAD:ToDoList/app/src/main/java/com/example/windows/todolist/Main2Activity.kt
import kotlinx.android.synthetic.main.activity_main2.*
=======
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
>>>>>>> parent of faba86e... Refatoração para o MVP e organização de pacotes por funcionalidades:ToDoList/app/src/main/java/com/example/windows/todolist/Main2Activity.kt
=======
>>>>>>> parent of 612b252... Alterações:ToDoList/app/src/main/java/com/example/windows/todolist/cenario/cenario_cadastro/Main2Activity.kt

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
