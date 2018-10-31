package com.example.windows.todolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.todo_item_list.view.*

class ToDoAdapter(val context: Context,val todos: List<ToDoList>)
    : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    //salva a função do clique no item
    var clickListener: ((todo:ToDoList, index: Int) -> Unit)? = null

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
        holder.bindView(todos[position], clickListener)
    }

    //configuração a função de clique nos itens
    fun setOnItemClickListener(clique: ((todo:ToDoList, index: Int) -> Unit)){
        this.clickListener = clique
    }

    //referência para a view de cada item da lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(todo: ToDoList, clickListener: ((todo:ToDoList, index: Int) -> Unit)?) {
            itemView.tvAdd.text = todo.ToDo


            if(clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(todo, adapterPosition)
                }
            }

        }

    }
}