package com.example.todolistapp.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TodoDTO(

    @SerializedName("todoIdx")
    var todoIdx: Int = 0,

    @SerializedName("todoContent")
    var todoContent: String = "",

    @SerializedName("todoWriteDate")
    var todoWriteDate: String = "",

    @SerializedName("todoDeletedYn")
    var todoDeletedYn: String = ""

) : Serializable



