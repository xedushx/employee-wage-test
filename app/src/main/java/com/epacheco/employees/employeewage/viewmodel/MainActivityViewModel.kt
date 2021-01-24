package com.epacheco.employees.employeewage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epacheco.employees.employeewage.model.EmployeesSetterGetter
import com.epacheco.employees.employeewage.repository.MainActivityRepository

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<EmployeesSetterGetter>? = null

    fun getEmployees() : LiveData<EmployeesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }
}