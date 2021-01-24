package com.epacheco.employees.employeewage.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

/**
 * Created by epacheco on 23,enero,2021
 * Siatigroup, Copyright
 */
class EmployeeApplication : Application() {
    companion object {
        lateinit var instance: EmployeeApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}