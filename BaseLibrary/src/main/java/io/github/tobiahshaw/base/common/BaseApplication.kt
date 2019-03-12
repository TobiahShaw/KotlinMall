package io.github.tobiahshaw.base.common

import android.app.Application
import io.github.tobiahshaw.base.injection.component.AppComponent
import io.github.tobiahshaw.base.injection.component.DaggerAppComponent
import io.github.tobiahshaw.base.injection.module.AppModule

class BaseApplication:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}