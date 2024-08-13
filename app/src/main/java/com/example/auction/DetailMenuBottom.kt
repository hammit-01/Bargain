package com.example.auction

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.auction.productpage.BuyActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//File Name: DetailMenuBottom.kt
//Author: 김혜미
//Date: 2024-08-06
//Description: 화면 하단 메뉴 바입니다
//
//Dependencies: -
//
//Version History: -
class DetailMenuBottom : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_menu_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 버튼 초기화 및 클릭 리스너 설정
        val myButton: Button = view.findViewById(R.id.button5)
        myButton.setOnClickListener {
            val intent = Intent(context, BuyActivity::class.java)
            startActivity(intent)
            dismiss() // BottomSheet 닫기
        }
    }
}
