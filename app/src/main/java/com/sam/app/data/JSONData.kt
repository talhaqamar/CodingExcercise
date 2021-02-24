package com.sam.app.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sam.app.model.Student
import java.lang.reflect.Type;

class JSONData {


    companion object {
        val json1: String = "[ { \"id\":1, \"name\":\"Alan\", \"degree_program\":\"ComputerScience\" }, { \"id\":2, \"name\":\"Jake\", \"degree_program\":\"BusinessAdministration\" }, { \"id\":3, \"name\":\"Hendrix\", \"degree_program\":\"BusinessAdministration\" }, { \"id\":4, \"name\":\"Paul\", \"degree_program\":\"BusinessAdministration\" }, { \"id\":5, \"name\":\"Dave\", \"degree_program\":\"ComputerScience\" }, { \"id\":6, \"name\":\"Mark\", \"degree_program\":\"ComputerScience\" }, { \"id\":7, \"name\":\"Henry\", \"degree_program\":\"NutritionalHealth\" }, { \"id\":8, \"name\":\"Charlie\", \"degree_program\":\"InternationalRelations\" }, { \"id\":9, \"name\":\"Harper\", \"degree_program\":\"InternationalRelations\" }, { \"id\":10, \"name\":\"Harry\", \"degree_program\":\"PublicAdministration\" }, { \"id\":11, \"name\":\"Jane\", \"degree_program\":\"SportScience\" }, { \"id\":12, \"name\":\"Sarah\", \"degree_program\":\"SportScience\" } ]"
       // val json: String = "[ { \"id\":1, “name”:“Alan”, “degree_program”:“ComputerScience” }, { “id”:2, “name”:“Jake”, “degree_program”:“BusinessAdministration” }, { “id”:3, “name”:“Hendrix”, “degree_program”:“BusinessAdministration” }, { “id”:4, “name”:“Paul”, “degree_program”:“BusinessAdministration” }, { “id”:5, “name”:“Dave”, “degree_program”:“ComputerScience” }, { “id”:6, “name”:“Mark”, “degree_program”:“ComputerScience” }, { “id”:7, “name”:“Henry”, “degree_program”:“NutritionalHealth” }, { “id”:8, “name”:“Charlie”, “degree_program”:“InternationalRelations” }, { “id”:9, “name”:“Harper”, “degree_program”:“InternationalRelations” }, { “id”:10, “name”:“Harry”, “degree_program”:“PublicAdministration” }, { “id”:11, “name”:“Jane”, “degree_program”:“SportScience” }, { “id”:12, “name”:“Sarah”, “degree_program”:“SportScience” } ]"

        fun parseJSON() : ArrayList<Student> {
            val gson = Gson()
            val type: Type = object : TypeToken<ArrayList<Student>>() {}.type
            val contactList: ArrayList<Student> = gson.fromJson(json1.trim(), type)
            for (contact in contactList) {
                Log.d("Contact Details", contact.id.toString() + "-" + contact.name + "-" + contact.degree_program)
            }
            return contactList as ArrayList<Student>
        }
    }
}