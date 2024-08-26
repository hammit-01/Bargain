package com.example.auction.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.auction.R

class TutorialPagerAdapter(
    private val context: Context,
    private val images: List<Int>
) : RecyclerView.Adapter<TutorialPagerAdapter.TutorialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.tutorial_page, parent, false)
        return TutorialViewHolder(view)
    }

    override fun onBindViewHolder(holder: TutorialViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class TutorialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.tutorialImage)

        fun bind(imageResId: Int) {
            imageView.setImageResource(imageResId)
        }
    }
}
