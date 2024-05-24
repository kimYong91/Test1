package com.busanit.test1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.busanit.test1.databinding.TodoBinding

lateinit var intent: Intent
class ToDoViewAdapter(val toDoList: MutableList<ToDo>) : RecyclerView.Adapter<ToDoViewAdapter.ToDoHolder>(){

    inner class ToDoHolder(val binding: TodoBinding) : RecyclerView.ViewHolder(binding.root) {
        var toDoText: TextView = binding.toDoText


        fun bind() {

            binding.deleteButton.setOnClickListener {
                val position = adapterPosition
                toDoList.removeAt(position)
                notifyItemRemoved(position)
            }
            binding.linearView.setOnClickListener {
                intent = Intent(binding.root.context, DetailActivity::class.java)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        val binding = TodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        val text = toDoList[position]
        holder.toDoText.text = text.todo
        holder.bind()
    }

    override fun getItemCount(): Int = toDoList.size

}