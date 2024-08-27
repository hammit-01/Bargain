package com.example.auction.usermanage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

// Todo loginActivity에 하단 메뉴 추가, 홈으로 못돌아가고 있음
// Todo 사용자 로그인시 개인페이지로 전환
class LoginActivity : AppCompatActivity() {
    private lateinit var tabMember: TextView
    private lateinit var tabSeller: TextView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var findPasswordTextView: TextView
    private lateinit var loginButton: TextView
    private lateinit var findEmailButton: Button
    private lateinit var signUpButton: Button
    private lateinit var kakaoLoginButton: LinearLayout
    private lateinit var logoutButton: Button

    // FirebaseAuth 인스턴스 초기화
    private var auth = FirebaseAuth.getInstance()

    private var isMemberSelected: Boolean = true // 기본적으로 회원 탭이 선택됨

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        // FirebaseAuth 인스턴스 초기화
        auth = FirebaseAuth.getInstance()

        // Initialize views
        tabMember = findViewById(R.id.tabMember)
        tabSeller = findViewById(R.id.tabSeller)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        findPasswordTextView = findViewById(R.id.findPasswordTextView)
        loginButton = findViewById(R.id.loginButton)
        findEmailButton = findViewById(R.id.findEmailButton)
        signUpButton = findViewById(R.id.signUpButton)
        kakaoLoginButton = findViewById(R.id.kakaoLoginButton)
        logoutButton = findViewById(R.id.logoutButton)

        // Set initial tab colors
        setTabColors(true)

        // 현재 사용자 가져오기
        val currentUser = auth.currentUser
        if (currentUser != null) {
            btnLogined()
            Logined()
        } else {
            btnNotLogined()
            notLogin()
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

    private fun notLogin() {
        // Tab button click listeners
        tabMember.setOnClickListener {
            // 회원 탭 클릭 시 동작
            setTabColors(true)
            kakaoLoginButton.visibility = LinearLayout.VISIBLE
            isMemberSelected = true // 회원 탭이 선택됨
        }

        tabSeller.setOnClickListener {
            // 판매자 탭 클릭 시 동작
            setTabColors(false)
            kakaoLoginButton.visibility = LinearLayout.GONE
            isMemberSelected = false // 판매자 탭이 선택됨
        }

        // 로그인 버튼 클릭 리스너
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                // 로그인 로직 처리
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "로그인 완료", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    }
            }
        }

        // 비밀번호 찾기 클릭 리스너
        findPasswordTextView.setOnClickListener {
            // 비밀번호 찾기 화면으로 이동
            Toast.makeText(this, "비밀번호 찾기", Toast.LENGTH_SHORT).show()
        }

        // 이메일 찾기 클릭 리스너
        findEmailButton.setOnClickListener {
            // 이메일 찾기 화면으로 이동
            Toast.makeText(this, "이메일 찾기", Toast.LENGTH_SHORT).show()
        }

        // 회원가입 클릭 리스너
        signUpButton.setOnClickListener {
            val intent = if (isMemberSelected) {
                Intent(this, SignUpCustomerActivity::class.java) // 회원가입 화면으로 이동
            } else {
                Intent(this, SignUpSellerActivity::class.java) // 판매자 가입 화면으로 이동
            }
            startActivity(intent)
        }

        // 카카오 로그인 버튼 클릭 리스너
        kakaoLoginButton.setOnClickListener {
            // 카카오 로그인 로직 처리
            Toast.makeText(this, "카카오 로그인 시도 중...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun Logined() {
        logoutButton.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun btnLogined() {
        tabMember.visibility = View.GONE
        tabSeller.visibility = View.GONE
        emailEditText.visibility = View.GONE
        passwordEditText.visibility = View.GONE
        findPasswordTextView.visibility = View.GONE
        loginButton.visibility = View.GONE
        findEmailButton.visibility = View.GONE
        signUpButton.visibility = View.GONE
        kakaoLoginButton.visibility = View.GONE
        logoutButton.visibility = View.VISIBLE
    }

    private fun btnNotLogined() {
        tabMember.visibility = View.VISIBLE
        tabSeller.visibility = View.VISIBLE
        emailEditText.visibility = View.VISIBLE
        passwordEditText.visibility = View.VISIBLE
        findPasswordTextView.visibility = View.VISIBLE
        loginButton.visibility = View.VISIBLE
        findEmailButton.visibility = View.VISIBLE
        signUpButton.visibility = View.VISIBLE
        kakaoLoginButton.visibility = View.VISIBLE
        logoutButton.visibility = View.GONE
    }
}
