package com.example.windows.todolist.cenario.cenario_cadastro

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.windows.todolist.cenario.cenario_lista.MainActivity
import com.example.windows.todolist.R
import com.example.windows.todolist.entidades.ToDoList
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), Main2ActivityContract.view {

    companion object {
        public const val TODO: String = "ToDo"
    }

    var todo: ToDoList? = null

    val presenter: Main2ActivityContract.Presenter = Main2ActivityPresenter(this)

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

        todo?.let {todo ->
            presenter.onSalvaToDo(this, todo)
        }

        val abreLista = Intent(this, MainActivity::class.java)
        abreLista.putExtra(TODO, todo)
        setResult(Activity.RESULT_OK, abreLista)
        finish()
    }

    private fun carregaDados() {
        addText.setText(todo?.ToDo)
    }

    override fun SalvoComSucesso(){
        Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT)
        finish()
    }
}
