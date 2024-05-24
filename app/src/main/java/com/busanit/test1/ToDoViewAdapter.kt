package com.busanit.test1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.busanit.test1.databinding.TodoBinding


class ToDoViewAdapter(val toDoList: MutableList<ToDo>) : RecyclerView.Adapter<ToDoViewAdapter.ToDoHolder>(){

    inner class ToDoHolder(val binding: TodoBinding) : RecyclerView.ViewHolder(binding.root) {
        var toDoText: TextView = binding.toDoText
        val toDoBind = binding.root.context

        fun bind() {
            binding.deleteButton.setOnClickListener {
                val position = adapterPosition
                toDoList.removeAt(position)
                notifyItemRemoved(position)
            }
            binding.linearView.setOnClickListener {
                val intent = Intent(toDoBind, DetailActivity::class.java)
                toDoBind.startActivity(intent)

                intent.putExtra("Key", binding.toDoText.text.toString())
                toDoBind.startActivity(intent)
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