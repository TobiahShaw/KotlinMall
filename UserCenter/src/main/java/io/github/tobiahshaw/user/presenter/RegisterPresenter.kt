package io.github.tobiahshaw.user.presenter

import io.github.tobiahshaw.base.ext.execute
import io.github.tobiahshaw.base.presenter.BasePresenter
import io.github.tobiahshaw.base.rx.BaseObserver
import io.github.tobiahshaw.user.presenter.view.RegisterView
import io.github.tobiahshaw.user.service.impl.UserServiceImpl

class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile: String, verifyCode: String, pwd: String) {
        // bloc
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
            .execute(object : BaseObserver<Boolean>(){
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            })
    }

}