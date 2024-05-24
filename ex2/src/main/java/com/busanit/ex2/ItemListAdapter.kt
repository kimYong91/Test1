package com.busanit.ex2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ex2.databinding.ItemBinding

class ItemListAdapter(val list: MutableList<Item>) : RecyclerView.Adapter<ItemListAdapter.ListViewHolder>(){

    inner class ListViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.run {
            itemText.text = list[position].text
        }
    }

}