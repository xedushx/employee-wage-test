package com.epacheco.employees.employeewage.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.epacheco.employees.employeewage.R
import com.epacheco.employees.employeewage.application.EmployeeApplication
import com.epacheco.employees.employeewage.model.EmployeeList
import com.bumptech.glide.request.target.Target

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
class EmployeeCardRecyclerViewAdapter(private val employeeList: List<EmployeeList>) : RecyclerView.Adapter<EmployeeCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeCardViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.employee_cardview, parent, false)
        return EmployeeCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: EmployeeCardViewHolder, position: Int) {
        if (position < employeeList.size) {
            val employee = employeeList[position]
            holder.employeeName.text = employee.name.substring(0,1) + ". "  + employee.lastName
            holder.employeeCompany.text = "Company: " + employee.company
            holder.employeeSavingPerWeek.text = "Saving per week: " + employee.savingPerWeek
            holder.employeeGoal.text = "Goal: $. " + employee.goal

            Glide
                .with(EmployeeApplication.instance)
                .load(employee.picture)
                .error(R.drawable.ic_mood_black_24dp)
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_mood_black_24dp)
                .into(holder.employeeImage)
        }
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }
}