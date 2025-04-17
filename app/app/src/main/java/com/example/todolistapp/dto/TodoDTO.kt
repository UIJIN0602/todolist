package com.example.todolistapp.dto

import com.google.gson.annotations.SerializedName

class TodoDTO (

    @SerializedName("todoIdx")
    var todoIdx: Int,

    @SerializedName("todoTitle")
    var todoTitle: String,

    @SerializedName("todoContent")
    var todoContent: String,

    @SerializedName("todoWriteDate")
    var todoWriteDate: String

    )



