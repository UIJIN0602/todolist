package com.example.todolistapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolistapp.appserver.AppServerClass
import com.example.todolistapp.databinding.ActivityMainBinding
import com.example.todolistapp.dto.TodoDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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

        loadtodolist()
    }
    private fun loadtodolist(){

        val api = AppServerClass.instance
        val call = api.selectTodo()
        retrofitResponse(call)
    }

    private fun retrofitResponse(call: Call<List<TodoDTO>>) {

        call.enqueue(object : Callback<List<TodoDTO>> {
            override fun onResponse(p0: Call<List<TodoDTO>>, res: Response<List<TodoDTO>>) {
                if (res.isSuccessful) {
                    val result = res.body()
                    Log.d("csy", "result : $result")

                } else {
                    Log.d("csy", "송신 실패, 상태 코드: ${res.code()}, 메시지: ${res.message()}")
                    //Log.d("csy", "송신 실패")
                    res.errorBody()?.let { errorBody ->
                        val error = errorBody.string()
                        Log.d("csy", "Error Response: $error")
                    }
                }
            }

            override fun onFailure(p0: Call<List<TodoDTO>>, t: Throwable) {
                Log.d("csy", "message : $t.message")
            }
        })
    }
}