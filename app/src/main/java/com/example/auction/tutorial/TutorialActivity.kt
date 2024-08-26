package com.example.auction.tutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.auction.MainActivity
import com.example.auction.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.auction.adapter.TutorialPagerAdapter

class TutorialActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var btnGetStarted: Button
    private lateinit var viewPagerAdapter: TutorialPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tab_layout)
        btnGetStarted = findViewById(R.id.btn_get_started)

        val tutorialImages = listOf(
            R.drawable.tutorial_image1,
            R.drawable.tutorial_image2,
            R.drawable.tutorial_image3,
            R.drawable.tutorial_image4
        )

        viewPagerAdapter = TutorialPagerAdapter(this, tutorialImages)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        btnGetStarted.isEnabled = false

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == tutorialImages.size - 1) {
                    btnGetStarted.isEnabled = true
                } else {
                    btnGetStarted.isEnabled = false
                }
            }
        })

        btnGetStarted.setOnClickListener {
            getSharedPreferences("tutorial", MODE_PRIVATE).edit()
                .putBoolean("isTutorialSeen", true)
                .apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}