package com.example.auction.productpage

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.auction.MainActivity
import com.example.auction.R
import com.example.auction.experience.ActivityPage
import com.google.android.material.bottomnavigation.BottomNavigationView

//File Name: BuyActivity.kt
//Author: 김혜미
//Date: 2024-07-29
//Description: 구매 신청서 페이지입니다.
//
//Dependencies: -
//
//Version History: -
class BuyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buy_detail)

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
        myTextView.text = "상품 구매"

        val items = arrayOf("부재 시 경비실에 맡겨주세요.","집 앞에 놔주세요.","택배함에 놔주세요","배송 전에 꼭 연락주세요.","직접 입력")

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, items)
        spinner.adapter = adapter
    }
}