package com.epacheco.employees.employeewage.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.epacheco.employees.employeewage.model.EmployeesSetterGetter
import com.epacheco.employees.employeewage.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
object MainActivityRepository {
    val serviceSetterGetter = MutableLiveData<EmployeesSetterGetter>()

    fun getServicesApiCall(): MutableLiveData<EmployeesSetterGetter> {

        val call = RetrofitClient.apiInterface.getEmployees()

        call.enqueue(object: Callback<EmployeesSetterGetter> {
            override fun onFailure(call: Call<EmployeesSetterGetter>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<EmployeesSetterGetter>,
                response: Response<EmployeesSetterGetter>
            ) {

                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val bankInfo = data!!.bankInfo
                val employeeList = data.employeeList
                val jobs = data.jobs

                serviceSetterGetter.value = EmployeesSetterGetter(bankInfo,employeeList,jobs)
            }
        })

        return serviceSetterGetter
    }
}