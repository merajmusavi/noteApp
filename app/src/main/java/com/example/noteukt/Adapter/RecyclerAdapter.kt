package com.example.noteukt.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteukt.Activity.AddNotesActivity
import com.example.noteukt.DataBase.DataModel
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

        holder.item.mainCard.setOnClickListener {
            val intent = Intent(con,AddNotesActivity::class.java)
            intent.putExtra("clickedOnItem",true)
            con.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return li.size
    }


}