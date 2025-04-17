package com.example.todolistapp.appserver


import com.example.todolistapp.dto.TodoDTO
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AppServerInterface {

@GET("selectTodo")
fun selectTodo(): Call<List<TodoDTO>>


@POST("insetTodo")
fun insetTodo(

)

@PUT("updateTodo")
fun updateTodo(

)

@DELETE("deleteTodo")
fun deleteTodo(

)

}