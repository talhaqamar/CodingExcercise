package com.sam.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sam.app.data.JSONData
import com.sam.app.model.Student
import java.util.*
import java.util.stream.IntStream


class StudentViewModel : ViewModel() {
    var userMutableLiveData: MutableLiveData<ArrayList<Student>?>
    var userArrayList: ArrayList<Student>? = null
    fun init() {
        populateList()
        userMutableLiveData.value = userArrayList
    }

    fun populateList() {
        val user: Student?  // = Student()
//        user.name = "Talha "
//        user.degree_program = "Cloud Computing"
        userArrayList = ArrayList()
//        userArrayList!!.add(user)
//        userArrayList!!.add(user)
//        userArrayList!!.add(user)
//        userArrayList!!.add(user)
//        userArrayList!!.add(user)
//        userArrayList!!.add(user)
//       userArrayList =
         userArrayList = JSONData.parseJSON()



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
