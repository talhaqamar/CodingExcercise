package com.sam.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sam.app.data.JSONData
import com.sam.app.model.Student
import java.util.*
import kotlin.collections.ArrayList


class StudentViewModel : ViewModel() {
    var userMutableLiveData: MutableLiveData<ArrayList<Student>?>
    var studentArrayList: ArrayList<Student>? = null
    var allRecordsArrayList: ArrayList<Student>? = null
    var checkFiveRecords:Int = 0

    fun init() {
        studentArrayList = ArrayList()
        allRecordsArrayList = ArrayList()
        allRecordsArrayList = JSONData.parseJSON()
        populateList()
        userMutableLiveData.value = studentArrayList
    }

    fun populateList() {
         calculateRecords(studentArrayList)
    }

    private fun calculateRecords(student: ArrayList<Student>?){
        allRecordsArrayList!!.drop(student!!.size).forEach ForEach@{
            if (checkFiveRecords < 5 && student.size <= allRecordsArrayList!!.size) {
                checkFiveRecords++
                studentArrayList!!.add(it)
            } else return@ForEach
        }
        checkFiveRecords = 0
    }

    init {
        userMutableLiveData = MutableLiveData()

        // call your Rest API in init method
        init()
    }

    @JvmName("getUserMutableLiveData1")
    fun getUserMutableLiveData(): MutableLiveData<ArrayList<Student>?>? {
        return userMutableLiveData
    }
}


