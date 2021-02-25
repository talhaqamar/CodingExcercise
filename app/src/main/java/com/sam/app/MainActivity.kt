package com.sam.app


import android.os.Bundle
import android.widget.AbsListView
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
    var pastVisiblesItems:Int = 0
    var visibleItemCount:Int = 0
    var totalItemCount:Int = 0
    var mLayoutManager: LinearLayoutManager? = null
    var isScrolling = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        recyclerView = findViewById(R.id.rv_main)

        viewModel = ViewModelProviders.of(context!!).get(StudentViewModel::class.java)
        viewModel!!.getUserMutableLiveData()?.observe(context!!, userListUpdateObserver)

        mLayoutManager = LinearLayoutManager(this);
//        recyclerView!!.setLayoutManager(mLayoutManager);

        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                visibleItemCount = recyclerView.layoutManager!!.getChildCount()
                totalItemCount = recyclerView.layoutManager!!.getItemCount()
                pastVisiblesItems = (recyclerView.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()

                Toast.makeText(this@MainActivity, "Display Items: " +
                        recyclerView.adapter!!.itemCount // Just making sure it has correct number of items
//                        viewModel!!.studentArrayList!!.size
                        + "\nTotal Items: " + viewModel!!.allRecordsArrayList!!.size, Toast.LENGTH_SHORT).show()

                if (isScrolling && (visibleItemCount + pastVisiblesItems == totalItemCount)) {
                    isScrolling = false
                    viewModel!!.populateList()
                    recyclerViewAdapter!!.notifyDataSetChanged()
                }
            }
        })

    }

    var userListUpdateObserver: Observer<ArrayList<Student>?> = Observer<ArrayList<Student>?> { studentArrayList ->
        recyclerViewAdapter = StudentAdapter(context!!, studentArrayList)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.adapter = recyclerViewAdapter
        recyclerView!!.setLayoutManager(recyclerView!!.layoutManager);
    }
}
