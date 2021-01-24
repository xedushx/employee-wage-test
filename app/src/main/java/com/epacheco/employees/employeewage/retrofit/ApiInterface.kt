package com.epacheco.employees.employeewage.retrofit

import com.epacheco.employees.employeewage.model.EmployeesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
interface ApiInterface {
    @GET("21473259-9162-4797-97ed-0e1d364f98fa")
    fun getEmployees() : Call<EmployeesSetterGetter>
}