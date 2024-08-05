package com.example.auction.usermanage

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.auction.MainActivity
import com.example.auction.R

// File Name: DetailMenuBottom.kt
// Author: 김채희
// Date: 2024-08-06
// Description: 로그인 화면입니다.
//
// Dependencies: -
//
// Version History:
class LoginActivity : AppCompatActivity() {
    private lateinit var tabMember: TextView
    private lateinit var tabSeller: TextView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var findPasswordTextView: TextView
    private lateinit var loginButton: TextView
    private lateinit var findEmailTextView: TextView
    private lateinit var signUpTextView: TextView
    private lateinit var kakaoLoginButton: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        // Initialize views
        tabMember = findViewById(R.id.tabMember)
        tabSeller = findViewById(R.id.tabSeller)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        findPasswordTextView = findViewById(R.id.findPasswordTextView)
        loginButton = findViewById(R.id.loginButton)
        findEmailTextView = findViewById(R.id.findEmailTextView)
        signUpTextView = findViewById(R.id.signUpTextView)
        kakaoLoginButton = findViewById(R.id.kakaoLoginButton)

        // Set initial tab colors
        setTabColors(true)

        // Tab button click listeners
        tabMember.setOnClickListener {
            // 회원 탭 클릭 시 동작
            setTabColors(true)
            kakaoLoginButton.visibility = LinearLayout.VISIBLE
        }

        tabSeller.setOnClickListener {
            // 판매자 탭 클릭 시 동작
            setTabColors(false)
            kakaoLoginButton.visibility = LinearLayout.GONE
        }

        // 로그인 버튼 클릭 리스너
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                // 로그인 로직 처리
                Toast.makeText(this, "로그인 시도 중...", Toast.LENGTH_SHORT).show()

                // 예시: 로그인 성공 후 메인 액티비티로 이동
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // 비밀번호 찾기 클릭 리스너
        findPasswordTextView.setOnClickListener {
            // 비밀번호 찾기 화면으로 이동
            Toast.makeText(this, "비밀번호 찾기", Toast.LENGTH_SHORT).show()
        }

        // 이메일 찾기 클릭 리스너
        findEmailTextView.setOnClickListener {
            // 이메일 찾기 화면으로 이동
            Toast.makeText(this, "이메일 찾기", Toast.LENGTH_SHORT).show()
        }

        // 회원가입 클릭 리스너
        signUpTextView.setOnClickListener {
            // 회원가입 화면으로 이동
            Toast.makeText(this, "회원가입", Toast.LENGTH_SHORT).show()
        }

        // 카카오 로그인 버튼 클릭 리스너
        kakaoLoginButton.setOnClickListener {
            // 카카오 로그인 로직 처리
            Toast.makeText(this, "카카오 로그인 시도 중...", Toast.LENGTH_SHORT).show()
        }
    }

    //회원, 판매자 탭시 글자색 변경
    private fun setTabColors(isMemberSelected: Boolean) {
        if (isMemberSelected) {
            tabMember.setTextColor(ContextCompat.getColor(this, R.color.black))
            tabSeller.setTextColor(ContextCompat.getColor(this, R.color.middle_gray))
        } else {
            tabMember.setTextColor(ContextCompat.getColor(this, R.color.middle_gray))
            tabSeller.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }
}
