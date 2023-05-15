package com.example.noteukt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteukt.databinding.NoteItemBinding

class RecyclerAdapter(val con: Context, val li: MutableList<DataModel>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(val item: NoteItemBinding) : RecyclerView.ViewHolder(item.root)
    {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            NoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item.tvDescription.text = li[position].description
        holder.item.tvTitle.text = li[position].title
    }

    override fun getItemCount(): Int {
        return li.size
    }


}