package com.example.mobdevprojectfull2try



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobdevprojectfull2try.databinding.ListItemBinding

class MyAdapter(private val newsList: List<News>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = newsList[position]
        holder.binding.titleImage.setImageResource(news.titleImage)
        holder.binding.tvHeading.text = news.heading
    }

    override fun getItemCount(): Int = newsList.size
}
