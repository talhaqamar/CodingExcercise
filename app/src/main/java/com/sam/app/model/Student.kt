package com.sam.app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Student(
        @SerializedName("id")
        @Expose
        var id:Int,
        @SerializedName("name")
        @Expose
        var name:String,
        @SerializedName("degree_program")
        @Expose
        var degree_program:String)

