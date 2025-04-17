package com.example.todolistapp.appserver


import android.R
import com.example.todolistapp.dto.TodoDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AppServerInterface {

@GET("selectTodo")
fun selectTodo(): Call<List<TodoDTO>>


@POST("insertTodo")
fun insertTodo(@Body todoDTO: TodoDTO):Call<String>



@PUT("updateTodo")
fun updateTodo(@Body todoDTO: TodoDTO): Call<String>


@DELETE("deleteTodo")
fun deleteTodo(

)

//    @GET("selectCompletedTodo")
//    fun selectCompletedTodo(): Call<List<TodoDTO>>

}