package com.example.auction.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auction.ItemData
import com.example.auction.R
import com.example.auction.experience.ActivityDetail

//File Name: PosterAdapter.kt
//Author: 김혜미
//Date: 2024-08-06
//Description: 
//
//Dependencies: -
//
//Version History: -
class PosterAdapter(private val context: Context, private val data: List<ItemData>) :
    RecyclerView.Adapter<PosterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.poster_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textView1.text = item.text1
        holder.textView2.text = item.text2

        // LinearLayout 클릭 리스너 설정
        holder.linearLayout.setOnClickListener {
            val intent = Intent(context, ActivityDetail::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
    }
}