package com.example.auction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auction.adapter.DetailAdapter
import com.example.auction.adapter.HorizontalAdapter
import com.example.auction.adapter.PosterAdapter
import com.example.auction.experience.ActivityPage
import com.example.auction.productpage.ProductActivity
import com.example.auction.usermanage.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

//

// 아래는 주석문 매뉴얼입니다
//File Name: MainActivity.kt
//Author: 김혜미
//Date: 2024-08-06
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
        // Top NavigationView 설정
        val topNavigationView = findViewById<BottomNavigationView>(R.id.topNavigationView)
        topNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_alarm -> {
                    // Todo alarm 메뉴 클릭 처리
                    // onBackPressedDispatcher.onBackPressed()
                    true
                }
                R.id.navigation_find -> {
                    // Todo find 메뉴 클릭 처리
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
                    true
                }
                R.id.navigation_cart -> {
                    // Todo cart 메뉴 클릭 처리
//                    val intent = Intent(this, ActivityPage::class.java)
//                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Bottom NavigationView 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_menu -> {
                    // Todo menu 메뉴 클릭 처리
                    // onBackPressedDispatcher.onBackPressed()
                    true
                }
                R.id.navigation_home -> {
                    // Todo home 메뉴 클릭 처리
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_like -> {
                    // Todo like 메뉴 클릭 처리
//                    val intent = Intent(this, ActivityPage::class.java)
//                    startActivity(intent)
                    true
                }
                R.id.navigation_user -> {
                    // Todo user 메뉴 클릭 처리
                    val intent = Intent(this, LoginActivity::class.java)
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

        val btn1 = findViewById<Button>(R.id.button1)
        btn1.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }
        val btn2 = findViewById<Button>(R.id.button2)
//        btn1.setOnClickListener {
//            val intent = Intent(this, ProductActivity::class.java)
//            startActivity(intent)
//        }
        val btn3 = findViewById<Button>(R.id.button3)
        btn3.setOnClickListener {
            val intent = Intent(this, ActivityPage::class.java)
            startActivity(intent)
        }

        val gridView1 = findViewById<RecyclerView>(R.id.gridView1)
        val gridView2 = findViewById<RecyclerView>(R.id.gridView2)
        gridView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        gridView1.adapter = HorizontalAdapter(this, data)
        gridView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        gridView2.adapter = HorizontalAdapter(this, data)
        gridView2.adapter = HorizontalAdapter(this, data)

        val recyclerView1 = findViewById<RecyclerView>(R.id.recyclerView1)
        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.adapter = DetailAdapter(this, data)
        recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.adapter = PosterAdapter(this, data)

        // Todo 사용자 로그인 여부에 따라 튜토리얼 액티비티 이동
    }
}