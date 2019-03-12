package io.github.tobiahshaw.user.injection.component

import dagger.Component
import io.github.tobiahshaw.user.injection.module.UserModule
import io.github.tobiahshaw.user.ui.activity.RegisterActivity

@Component(modules = [UserModule::class])
interface UserComponent {
    fun inject(activity:RegisterActivity)
}