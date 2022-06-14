package com.example.whac_a_mole

import android.app.Application

class DaggerApplication : Application() {

    companion object {
        var appComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
    }

    private fun initDagger(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .bindContext(this@DaggerApplication)
            .build()
    }
}