package com.example.auction.experience

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auction.adapter.DetailAdapter
import com.example.auction.ItemData
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.android.material.bottomnavigation.BottomNavigationView

//File Name: ActivityDetail.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 체험 상세 페이지입니다
//
//Dependencies: -
//
//Version History: -
class ActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

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
                    val intent = Intent(this, AppliActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

        val data = listOf(
            ItemData(R.drawable.img1, "00마켓", "햇감자 1kg", "3만원 부터"),
            ItemData(R.drawable.img2, "xx마켓", "제주 은갈치 200g", "1만원 부터"),
            ItemData(R.drawable.img1, "00마켓", "햇감자 1kg", "3만원 부터")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = DetailAdapter(this, data)

        // 버튼 클릭 또는 다른 이벤트로 BottomSheet 호출
        findViewById<View>(R.id.show_bottom_sheet_button).setOnClickListener {
            val intent = Intent(this, AppliActivity::class.java)
            startActivity(intent)
        }
    }
}