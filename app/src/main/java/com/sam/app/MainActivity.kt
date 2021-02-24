package com.sam.app


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.app.adapter.StudentAdapter
import com.sam.app.model.Student
import com.sam.app.viewmodel.StudentViewModel
import java.util.*


class MainActivity : AppCompatActivity(), LifecycleOwner {
    var context: MainActivity? = null
    var viewModel: StudentViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: StudentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        recyclerView = findViewById(R.id.rv_main)
        viewModel = ViewModelProviders.of(context!!).get(StudentViewModel::class.java)
        viewModel!!.getUserMutableLiveData()?.observe(context!!, userListUpdateObserver)


    }

    var userListUpdateObserver: Observer<ArrayList<Student>?> = Observer<ArrayList<Student>?> { userArrayList ->
        recyclerViewAdapter = StudentAdapter(context!!, userArrayList)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.adapter = recyclerViewAdapter
        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) { //1 for down
                    Toast.makeText(this@MainActivity, "Scroll To bottom",Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
