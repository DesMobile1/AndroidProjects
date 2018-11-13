package com.example.windows.todolist.cenario.cenario_lista

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.windows.todolist.R
import com.example.windows.todolist.entidades.ToDoList
import kotlinx.android.synthetic.main.todo_item_list.view.*

class ToDoAdapter(val context: Context,val todos: List<ToDoList>)
    : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    //salva a função do clique no item
    var clickListener: ((index: Int) -> Unit)? = null
    var clickListener2: ((index: Int)-> Unit)? = null

    //método responsável por inflar as views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item_list, parent, false)
        return ViewHolder(view)
    }

    //retorna a quantidade de itens na lista
    override fun getItemCount(): Int {
        return todos.size
    }

    //popula o ViewHolder com as informações do contatinho
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, todos[position], clickListener, clickListener2)
    }

    //configuração a função de clique nos itens
    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.clickListener = clique
    }

    fun setOnItemClickListener2(clique2: ((index: Int) -> Unit)){
        this.clickListener2 = clique2
    }

    //referência para a view de cada item da lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, todo: ToDoList, clickListener: ((index: Int) -> Unit)?, clickListener2: ((index: Int) -> Unit)?) {
            itemView.tvAdd.text = todo.ToDo


            if(clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(adapterPosition)
                }
            }

            if(clickListener2 != null) {
                itemView.setOnClickListener {
                    clickListener2.invoke(adapterPosition)
                }
            }

        }

    }
}