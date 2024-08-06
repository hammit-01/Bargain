package com.example.auction.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auction.ItemData
import com.example.auction.R
import com.example.auction.experience.ActivityDetail

//File Name: HorizontalAdapter.kt
//Author: 김혜미
//Date: 2024-08-06
//Description: 
//
//Dependencies: -
//
//Version History: -
class HorizontalAdapter(private val context: Context, private val data: List<ItemData>) :
    RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textView1.text = item.text1
        holder.textView2.text = item.text2
        holder.textView3.text = item.text3

        // LinearLayout 클릭 리스너 설정
        holder.linearLayout.setOnClickListener {
            val intent = Intent(context, ActivityDetail::class.java)
            context.startActivity(intent)
        }

        // 버튼 초기화 및 클릭 리스너 설정

        holder.myButton.setOnClickListener {
            val intent = Intent(context, ActivityDetail::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val textView3: TextView = itemView.findViewById(R.id.textView3)
        val linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
        val myButton: Button = itemView.findViewById(R.id.button)
    }
}