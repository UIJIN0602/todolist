package com.example.todolistapp.appserver

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

//  Retrofit 의 기본 설정 클래스
object AppServerClass {

    // 실제 디바이스에서 테스트할 때, PC의 IP 주소를 사용해야 함
    private val BASE_URL = "http://10.100.203.91:8080/todolist/"



    val instance: AppServerInterface by lazy {
        Retrofit.Builder()
//      서버 기본 주소
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppServerInterface::class.java)
    }
}