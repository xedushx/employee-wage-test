package com.epacheco.employees.employeewage.util

import com.epacheco.employees.employeewage.model.EmployeeJobView
import com.epacheco.employees.employeewage.model.EmployeeList
import com.epacheco.employees.employeewage.model.EmployeeView
import com.epacheco.employees.employeewage.model.Job

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
object EmployeeUtils {

    fun getBestWageByTime (jobList: List<Job>, employee: EmployeeList): EmployeeView {
        var employeeView = EmployeeView()
        val iterator = jobList.iterator()

        employeeView.id = employee.id
        employeeView.displayName = "${employee.name.substring(0,1)}. ${employee.lastName}"
        employeeView.goal = "Goal: $. ${employee.goal}"
        employeeView.savingPerWeek = "Saving per week: ${employee.savingPerWeek}"
        employeeView.picture = employee.picture

        var employeeJobs: MutableList<EmployeeJobView> = mutableListOf()

        iterator.forEach {
            var total = 0.0
            val totalTimePerWeek = employee.weekDayHours + employee.weekEndHours
            if (it.minHoursPerWeek <= totalTimePerWeek &&
                totalTimePerWeek <= it.maxHoursPerWeek){
                val weekWage = employee.weekDayHours * it.weekDayHourlyWage
                val weekEndWage = employee.weekEndHours * it.weekEndDayHourlyWage

                total = weekWage + weekEndWage

                val employeeJob = EmployeeJobView(it.name, total)
                employeeJobs.add(employeeJob)
            }
        }

        var months = 0

        if (employeeJobs.isNotEmpty()){
            val maxWageByJob = employeeJobs.maxBy { it.value }

            employeeView.job = listOf(maxWageByJob!!)

            val savingPerWeek = employee.savingPerWeek.replace('%', ' ').trim().toLongOrNull()
            var savingTotalPerWeek = 0.0
            if (savingPerWeek != null) {
                savingTotalPerWeek = savingPerWeek * maxWageByJob.value / 100
            }

            val weeks = (employee.goal / savingTotalPerWeek).toInt()

            months = (weeks / 4)
        } else {
            //TODO divide time in more than one job
        }

        employeeView.months = months

        return employeeView
    }
}