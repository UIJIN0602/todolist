package com.example.todolistapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolistapp.appserver.AppServerClass
import com.example.todolistapp.databinding.ActivityMainBinding
import com.example.todolistapp.databinding.ActivityPlusBinding
import com.example.todolistapp.dto.TodoDTO
import kotlinx.coroutines.MainScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlusActivity : AppCompatActivity() {

    private val binding: ActivityPlusBinding by lazy {
        ActivityPlusBinding.inflate(layoutInflater)
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
        binding.btnWrite.setOnClickListener {

            val todoContent = binding.etMemo.text.toString()

            // 예시: 제목과 날짜는 고정 값 또는 다른 입력값에서 받아온다고 가정
            val todoDTO = TodoDTO(
                todoContent = todoContent
            )

            val api = AppServerClass.instance
            val call = api.insertTodo(todoDTO)
            retrofitResponse(call)
        }

    }

    private fun retrofitResponse(call: Call<String>) {

        call.enqueue(object : Callback<String> {
            override fun onResponse(p0: Call<String>, res: Response<String>) {
                if (res.isSuccessful) {
                    val result = res.body()
                    Log.d("csy", "result : $result")

                    val intent = Intent(this@PlusActivity, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Log.d("csy", "송신 실패, 상태 코드: ${res.code()}, 메시지: ${res.message()}")
                    //Log.d("csy", "송신 실패")
                    res.errorBody()?.let { errorBody ->
                        val error = errorBody.string()
                        Log.d("csy", "Error Response: $error")
                    }
                }
            }

            override fun onFailure(p0: Call<String>, t: Throwable) {
                Log.d("csy", "message : $t.message")
            }
        })
    }
}