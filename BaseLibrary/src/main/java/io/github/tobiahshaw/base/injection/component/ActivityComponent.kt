package io.github.tobiahshaw.base.injection.component

import android.app.Activity
import dagger.Component
import io.github.tobiahshaw.base.injection.ActivityScope
import io.github.tobiahshaw.base.injection.module.ActivityModule

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {
    fun activity(): Activity
}