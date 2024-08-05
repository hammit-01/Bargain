package com.example.auction.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.auction.productpage.DetailActivity
import com.example.auction.ItemData
import com.example.auction.R

//File Name: GridAdapter.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 그리드 형식의 어댑터입니다
//
//Dependencies: -
//
//Version History: -
class GridAdapter(private val context: Context, private val data: List<ItemData>) : BaseAdapter() {
    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = data[position]
        viewHolder.imageView.setImageResource(item.imageResId)
        viewHolder.textView1.text = item.text1
        viewHolder.textView2.text = item.text2
        viewHolder.textView3.text = item.text3

        // LinearLayout 클릭 리스너 설정
        viewHolder.linearLayout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }

        return view
    }

    private class ViewHolder(view: View) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textView1: TextView = view.findViewById(R.id.textView1)
        val textView2: TextView = view.findViewById(R.id.textView2)
        val textView3: TextView = view.findViewById(R.id.textView3)
        val linearLayout: LinearLayout = view.findViewById(R.id.linearLayout)
    }
}