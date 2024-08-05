package com.example.auction.productpage

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.auction.experience.ActivityPage
import com.example.auction.adapter.GridAdapter
import com.example.auction.ItemData
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.android.material.bottomnavigation.BottomNavigationView

//File Name: ProductActivity.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 상품 페이지 화면입니다.
//
//Dependencies: -
//
//Version History: -
class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_page)

        // Todo 메인 엑티비티 변경
        // NavigationView 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_back -> {
                    // Todo back 메뉴 클릭 처리
                    onBackPressedDispatcher.onBackPressed()
                    true
                }
                R.id.navigation_home -> {
                    // Todo home 메뉴 클릭 처리
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_find -> {
                    // Todo find 메뉴 클릭 처리
                    val intent = Intent(this, ActivityPage::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val data = listOf(
            // Todo Data Set (Database set)
            ItemData(R.drawable.img1, "3,000원 부터", "00마켓", "햇감자 1kg"),
            ItemData(R.drawable.img2, "10,000원 부터", "xx마켓", "제주 은갈치 200g"),
            ItemData(R.drawable.img1, "3,000원 부터", "00마켓", "햇감자 1kg"),
            ItemData(R.drawable.img2, "10,000원 부터", "xx마켓", "제주 은갈치 200g"),
            ItemData(R.drawable.img1, "3,000원 부터", "00마켓", "햇감자 1kg"),
            ItemData(R.drawable.img2, "10,000원 부터", "xx마켓", "제주 은갈치 200g")
        )

        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = GridAdapter(this, data)
    }
}