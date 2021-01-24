package com.epacheco.employees.employeewage.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.epacheco.employees.employeewage.R
import com.epacheco.employees.employeewage.util.EmployeeGridItemDecoration
import com.epacheco.employees.employeewage.viewmodel.EmployeeCardRecyclerViewAdapter
import com.epacheco.employees.employeewage.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        callApiService()

    }

    private fun callApiService() {
        wp7progressBar.showProgressBar()

        mainActivityViewModel.getEmployees()!!.observe(this, Observer { serviceSetterGetter ->

            wp7progressBar.hideProgressBar()
            val bankInfo = serviceSetterGetter.bankInfo
            val employeeList = serviceSetterGetter.employeeList.sortedBy { employeeObj -> employeeObj.goal }
            val jobs = serviceSetterGetter.jobs

            //TODO pass the algorithm to estimate time and jobs for goal

            recycler_view.setHasFixedSize(true)
            recycler_view.layoutManager = GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
            val adapter = EmployeeCardRecyclerViewAdapter(employeeList)
            recycler_view.adapter = adapter

        })
    }

}
