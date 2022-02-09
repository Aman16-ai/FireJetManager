package com.example.mvvmnote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnote.data.Password

class PasswordAdapter(var context : Context) : RecyclerView.Adapter<PasswordAdapter.myViewHolder>() {

    private var allpasswords : MutableList<Password> = ArrayList<Password>()

    inner class myViewHolder(view : View) :  RecyclerView.ViewHolder(view) {
        var title_tv: TextView = view.findViewById(R.id.title_tv_pass)
        var password_tv : TextView = view.findViewById(R.id.password_tv_pass)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(context)
       val view = inflater.inflate(R.layout.pass_list,parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.title_tv.text = allpasswords[position].name
        holder.password_tv.text = allpasswords[position].password
    }

    override fun getItemCount(): Int {
        return allpasswords.size
    }

    fun setPassword(passwords : MutableList<Password>) {
        allpasswords.clear()
        allpasswords.addAll(passwords)
        notifyDataSetChanged()
    }
}