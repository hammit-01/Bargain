package com.example.auction.usermanage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.firebase.auth.FirebaseAuth

class SignUpCustomerActivity : AppCompatActivity() {
    private lateinit var signUpButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    // FirebaseAuth 인스턴스 초기화
    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_customer) // sign_up_customer.xml 레이아웃을 사용합니다.

        // FirebaseAuth 인스턴스 초기화
        auth = FirebaseAuth.getInstance()

        // 고객 회원가입 로직 추가
        signUpButton = findViewById(R.id.signUpConfirmButton)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        signUpButton.setOnClickListener {
            auth.createUserWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "회원가입 완료", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "회원가입 실패", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
        }
    }
}
