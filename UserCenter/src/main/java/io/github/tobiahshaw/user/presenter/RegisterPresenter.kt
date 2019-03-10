package io.github.tobiahshaw.user.presenter

import io.github.tobiahshaw.base.presenter.BasePresenter
import io.github.tobiahshaw.user.presenter.view.RegisterView
import java.util.*

class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile: String, validifyCode: String) {
        // bloc
        mView.onRegisterResult(Random().nextBoolean())
    }

}