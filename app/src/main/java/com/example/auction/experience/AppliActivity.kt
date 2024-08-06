package com.example.auction.experience

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.android.material.bottomnavigation.BottomNavigationView

//File Name: AppliActivity.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 체험 신청 페이지입니다
//
//Dependencies: -
//
//Version History: -
class AppliActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appli_detail)

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
        myTextView.text = "체험 신청"
    }
}