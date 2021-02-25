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
//        val user: Student?  // = Student()
//        user.name = "Talha "
//        user.degree_program = "Cloud Computing"



//        for (i in calculateRecords(studentArrayList!!)) {
//            if (checkFiveRecords < 5) {
//                if (studentArrayList!!.size >= 0 && studentArrayList!!.size <= 5 && allRecordsArrayList!!.size >= studentArrayList!!.size) {
//                    checkFiveRecords++
//                    studentArrayList!!.add(i)
//                } else if (studentArrayList!!.size >= 5 && allRecordsArrayList!!.size >= studentArrayList!!.size) {
//                    checkFiveRecords++
//                    studentArrayList!!.add(i)
//                }
//            } else {
//                checkFiveRecords = 0
//                break
//            }
//
           var studentArray: ArrayList<Student> = calculateRecords(studentArrayList)
//
//
//        }
    }

    private fun calculateRecords(student: ArrayList<Student>?): ArrayList<Student> {
        var list :ArrayList<Student> = ArrayList()
        checkFiveRecords = 0;


         allRecordsArrayList!!.drop(student!!.size).forEach ForEach@{

            if (checkFiveRecords < 5 && list.size<=5) {
                checkFiveRecords++
                studentArrayList!!.add(it)
                list.add(it)
            } else return@ForEach


        }

        checkFiveRecords = 0
        return  list
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


