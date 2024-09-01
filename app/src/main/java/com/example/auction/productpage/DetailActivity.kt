package com.example.auction.productpage

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auction.DetailMenuBottom
import com.example.auction.ItemData
import com.example.auction.R
import com.example.auction.adapter.DetailAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

//File Name: DetailActivity.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 상품 페이지에서 상품을 클릭했을 때 나타나는 상품 상세 페이지입니다.
//
//Dependencies: -
//
//Version History: -
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_detail)

        // Top NavigationView 설정
        val topNavigationView = findViewById<BottomNavigationView>(R.id.topNavigationView)
        topNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_back -> {
                    // Todo menu 메뉴 클릭 처리
                     onBackPressedDispatcher.onBackPressed()
                    true
                }
                R.id.navigation_find -> {
                    // Todo home 메뉴 클릭 처리
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
                    true
                }
                R.id.navigation_cart -> {
                    // Todo like 메뉴 클릭 처리
//                    val intent = Intent(this, ActivityPage::class.java)
//                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // 상단 바 텍스트 설정
        val myTextView: TextView = findViewById(R.id.appTitle)
        myTextView.text = "상품"

        val data = listOf(
            ItemData(R.drawable.img1, "00마켓", "햇감자 1kg", "3만원 부터"),
            ItemData(R.drawable.img2, "xx마켓", "제주 은갈치 200g", "1만원 부터"),
            ItemData(R.drawable.img1, "00마켓", "햇감자 1kg", "3만원 부터")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = DetailAdapter(this, data)

        // 버튼 클릭 또는 다른 이벤트로 BottomSheet 호출
        findViewById<View>(R.id.show_bottom_sheet_button).setOnClickListener {
            val bottomSheet = DetailMenuBottom()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }
}