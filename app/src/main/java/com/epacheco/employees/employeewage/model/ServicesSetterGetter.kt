package com.epacheco.employees.employeewage.model

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
data class EmployeesSetterGetter (
    val bankInfo: BankInfo,
    val employeeList: List<EmployeeList>,
    val jobs: List<Job>
)

data class BankInfo (
    val apy: String
)

data class EmployeeList (
    val id: String,
    val name: String,
    val lastName: String,
    val picture: String,
    val weekDayHours: Int,
    val weekEndHours: Int,
    val savingPerWeek: String,
    val goal: Double,
    val company: String
)

data class Job (
    val name: String,
    val weekDayHourlyWage: Double,
    val weekEndDayHourlyWage: Double,
    val maxHoursPerWeek: Int,
    val minHoursPerWeek: Int
)

data class EmployeeJobView (
    var name: String = "",
    var value: Double = 0.0
)

data class EmployeeView (
    var id: String = "",
    var displayName: String = "",
    var picture: String = "",
    var savingPerWeek: String = "",
    var goal: String = "",
    var months: Int = 0,
    var job: List<EmployeeJobView> = emptyList()
)

