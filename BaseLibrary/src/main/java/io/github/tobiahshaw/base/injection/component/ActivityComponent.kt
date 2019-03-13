package io.github.tobiahshaw.base.injection.component

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component
import io.github.tobiahshaw.base.injection.ActivityScope
import io.github.tobiahshaw.base.injection.module.ActivityModule
import io.github.tobiahshaw.base.injection.module.LifecycleProviderModule

@ActivityScope
@Component(modules = [ActivityModule::class, LifecycleProviderModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}