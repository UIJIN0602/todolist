package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolistapp.MainActivity
import com.example.todolistapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy{
        ActivitySplashBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        Handler(Looper.getMainLooper()).postDelayed(Runnable {      //Handler함수로 SplashActivity의 딜레이 시간 지정
            startActivity(Intent(this, MainActivity::class.java))   //딜레이준 다음 어떤 엑티비티로 이동할건지(MainActivity로 이동)
            finish()                // 현재 엑티비티 종료 (SplashActivity는 이동한다음에는 쓸모없어지기 때문)
        },2000)                 // 1500 = 1.5초 , 2000 = 2초

    }
}
