package io.github.tobiahshaw.user.presenter.view

import io.github.tobiahshaw.base.presenter.view.BaseView

interface RegisterView : BaseView {
    fun onRegisterResult(success: Boolean)
}