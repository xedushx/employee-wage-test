package com.epacheco.employees.employeewage.viewmodel

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.epacheco.employees.employeewage.R

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
class EmployeeCardViewHolder (itemView: View)
    : RecyclerView.ViewHolder(itemView){

    var employeeImage: ImageView = itemView.findViewById(R.id.employee_image)
    var employeeName: TextView = itemView.findViewById(R.id.name)
    var employeeCompany: TextView = itemView.findViewById(R.id.company)
    var employeeYearWage: TextView = itemView.findViewById(R.id.year_wage)
    var employeeGoal: TextView = itemView.findViewById(R.id.goal)
    var employeeMonths: TextView = itemView.findViewById(R.id.months)
    var employeeSavingPerWeek: TextView = itemView.findViewById(R.id.saving_per_week)
    var employeeEditButton: Button = itemView.findViewById(R.id.edit_employee)

}