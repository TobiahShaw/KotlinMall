package io.github.tobiahshaw.user.presenter

import io.github.tobiahshaw.base.ext.execute
import io.github.tobiahshaw.base.presenter.BasePresenter
import io.github.tobiahshaw.base.rx.BaseObserver
import io.github.tobiahshaw.user.presenter.view.RegisterView
import io.github.tobiahshaw.user.service.UserService
import javax.inject.Inject

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, pwd: String, verifyCode: String) {
        // bloc

        if (!checkNetWork()) {
            return
        }

        userService.register(mobile, pwd, verifyCode)
            .execute(object : BaseObserver<Boolean>(mView){
                override fun onNext(t: Boolean) {
                    if (t)
                        mView.onRegisterResult("注册成功！")
                }
            }, lifecycleProvider)
    }

}