package com.example.auction.usermanage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SignUpSellerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_seller) // sign_up_seller.xml 레이아웃을 사용합니다.

        // 판매자 회원가입 로직 추가

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
    }
}
