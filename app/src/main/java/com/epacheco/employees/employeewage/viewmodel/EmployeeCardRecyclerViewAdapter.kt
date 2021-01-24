package com.epacheco.employees.employeewage.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.epacheco.employees.employeewage.R
import com.epacheco.employees.employeewage.application.EmployeeApplication
import com.epacheco.employees.employeewage.model.EmployeeView

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
class EmployeeCardRecyclerViewAdapter(private val employeeList: List<EmployeeView>) : RecyclerView.Adapter<EmployeeCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeCardViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.employee_cardview, parent, false)
        return EmployeeCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: EmployeeCardViewHolder, position: Int) {
        if (position < employeeList.size) {
            val employee = employeeList[position]
            holder.employeeName.text = employee.displayName
            holder.employeeCompany.text = "Company: ${employee.job.toString()}"
            holder.employeeSavingPerWeek.text = employee.savingPerWeek
            holder.employeeGoal.text = employee.goal
            holder.employeeMonths.text = "Months required: ${employee.months}"

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