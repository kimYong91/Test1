package com.busanit.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit.test1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toDoList = mutableListOf<ToDo>()
        val mainAdapter = ToDoViewAdapter(toDoList)
        val mainManager = LinearLayoutManager(this@MainActivity)
        val toDoDirection = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)


        binding.run {
            recyclerView.apply {
                adapter = mainAdapter
                layoutManager = mainManager
                addItemDecoration(toDoDirection)
            }

            saveButton.setOnClickListener {
                val text = ToDo(binding.editText.text.toString())
                toDoList.add(text)
                mainAdapter.notifyItemInserted(toDoList.size-1)
            }
        }

    }
}

