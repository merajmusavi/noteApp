package com.example.noteukt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val con: Context,val li : MutableList<DataModel>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val tvTitle: TextView = item.findViewById(R.id.tvTitle)
        val tvDec: TextView = item.findViewById(R.id.tvDescription)
        val buttonDelete: ImageView = item.findViewById(R.id.DeleteBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View = LayoutInflater.from(con).inflate(R.layout.note_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          holder.tvDec.text = li[position].description
        holder.tvTitle.text = li[position].title
    }

    override fun getItemCount(): Int {
        return li.size
    }

}