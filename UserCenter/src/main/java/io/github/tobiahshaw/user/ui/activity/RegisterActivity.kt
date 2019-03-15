package io.github.tobiahshaw.user.ui.activity

import android.os.Bundle
import io.github.tobiahshaw.base.common.AppManager
import io.github.tobiahshaw.base.ext.onClick
import io.github.tobiahshaw.base.ui.activity.BaseMVPActivity
import io.github.tobiahshaw.user.R
import io.github.tobiahshaw.user.injection.component.DaggerUserComponent
import io.github.tobiahshaw.user.injection.module.UserModule
import io.github.tobiahshaw.user.presenter.RegisterPresenter
import io.github.tobiahshaw.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {

    private var pressTime:Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegisterBtn.onClick {
            mPresenter.register(mMobileEt.text.toString(), mPWDEt.text.toString(), mVerifyCodeEt.text.toString())
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }
}
