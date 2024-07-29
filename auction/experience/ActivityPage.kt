package com.example.auction.experience

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.auction.ItemData
import com.example.auction.adapter.ListAdapter
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.android.material.bottomnavigation.BottomNavigationView

//File Name: ActivityPage.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 체험 프로그램 메인 페이지입니다
//
//Dependencies: -
//
//Version History: -
class ActivityPage: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

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
                    val intent = Intent(this, ActivityDetail::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val data = listOf(
            // Todo Data Set (Database set)
            ItemData(R.drawable.img1, "감자 체험", "00마켓", "감자 일꾼 구합니다"),
            ItemData(R.drawable.img2, "갈치 체험", "xx마켓", "너 내 동료가 되어라"),
            ItemData(R.drawable.img1, "감자 체험", "00마켓", "감자 일꾼 구합니다"),
            ItemData(R.drawable.img2, "갈치 체험", "xx마켓", "너 내 동료가 되어라"),
            ItemData(R.drawable.img1, "감자 체험", "00마켓", "감자 일꾼 구합니다"),
            ItemData(R.drawable.img2, "갈치 체험", "xx마켓", "너 내 동료가 되어라")
        )

        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = ListAdapter(this, data)
    }
}