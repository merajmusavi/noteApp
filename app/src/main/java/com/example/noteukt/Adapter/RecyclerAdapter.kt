package com.example.noteukt.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteukt.Activity.AddNotesActivity
import com.example.noteukt.Activity.MainActivity
import com.example.noteukt.DataBase.DataModel
import com.example.noteukt.databinding.NoteItemBinding

class RecyclerAdapter(val con: Context, var li: MutableList<DataModel>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    private var onButtonClicked:OnButtonClickListener? = null
    fun setonButtonClickListener(listener:OnButtonClickListener){
        onButtonClicked = listener
    }

    inner class MyViewHolder(val item: NoteItemBinding) : RecyclerView.ViewHolder(item.root)
    {
        init {

            item.mainCard.setOnLongClickListener {
                val position = adapterPosition
                onButtonClicked?.onButtonLongClicked(position)
            true
            }

            item.DeleteBtn.setOnClickListener {
                val position = adapterPosition
                onButtonClicked?.onButtonClicked(position)
            }
        }
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

    fun updateData(list:MutableList<DataModel>){
        li = list
        notifyDataSetChanged()

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item.tvDescription.text = li[position].description
        holder.item.tvTitle.text = li[position].title

        holder.item.mainCard.setOnClickListener {
            val intent = Intent(con,AddNotesActivity::class.java)
            intent.putExtra("clickedOnItem",true)
            intent.putExtra("position",position)
            con.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return li.size
    }

interface OnButtonClickListener{
    fun onButtonClicked(position: Int)
    fun onButtonLongClicked(position: Int)
}

}
