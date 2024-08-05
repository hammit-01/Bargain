package com.example.auction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import com.example.auction.adapter.GridAdapter
import com.example.auction.experience.ActivityPage
import com.example.auction.usermanage.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

// 아래는 주석문 매뉴얼입니다
//File Name: MainActivity.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: Bargain 어플의 메인 화면입니다.
//
//Dependencies: -
//
//Version History: -
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                R.id.navigation_my -> {
                    // Todo my 메뉴 클릭 처리
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }
}