package io.github.tobiahshaw.user.injection.component

import dagger.Component
import io.github.tobiahshaw.base.injection.PerComponentScope
import io.github.tobiahshaw.base.injection.component.ActivityComponent
import io.github.tobiahshaw.user.injection.module.UserModule
import io.github.tobiahshaw.user.ui.activity.RegisterActivity

@PerComponentScope
@Component(modules = [UserModule::class], dependencies = [ActivityComponent::class])
interface UserComponent {
    fun inject(activity:RegisterActivity)
}