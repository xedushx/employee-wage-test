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
    val weekDayHours: Long,
    val weekEndHours: Long,
    val savingPerWeek: String,
    val goal: Long,
    val company: String
)

data class Job (
    val name: String,
    val weekDayHourlyWage: Long,
    val weekEndDayHourlyWage: Long,
    val maxHoursPerWeek: Long,
    val minHoursPerWeek: Long
)

