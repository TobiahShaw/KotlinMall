package io.github.tobiahshaw.base.injection.component

import android.content.Context
import dagger.Component
import io.github.tobiahshaw.base.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context(): Context
}