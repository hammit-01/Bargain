package com.example.auction.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.auction.ItemData
import com.example.auction.R

//File Name: DetailAdapter.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 리싸이클러뷰 어댑터입니다. 상세 페이지 화면의 이미지를 양옆으로 스크롤할 수 있도록 해줍니다.
//
//Dependencies: -
//
//Version History: -
class DetailAdapter(private val context: Context, private val data: List<ItemData>) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.img_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.imageView.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}