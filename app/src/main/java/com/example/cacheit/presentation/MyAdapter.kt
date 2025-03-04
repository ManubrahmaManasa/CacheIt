package com.example.cacheit.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cacheit.databinding.ItemLayoutBinding
import com.example.cacheit.domain.Item

class MyAdapter(private var post:List<Item>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(private val binding:ItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Item){
            binding.tvTitle.text = item.title
            binding.tvBody.text = item.body
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.onBind(post[position])
    }

    override fun getItemCount(): Int = post.size

    fun updateData(item:List<Item>){
        post = item
        notifyDataSetChanged()
    }
}