package io.github.tobiahshaw.user.ui.activity

import android.os.Bundle
import io.github.tobiahshaw.base.ui.activity.BaseMVPActivity
import io.github.tobiahshaw.user.R
import io.github.tobiahshaw.user.presenter.RegisterPresenter
import io.github.tobiahshaw.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        mRegisterBtn.setOnClickListener {
            mPresenter.register(mMobileEt.text.toString(), mPWDEt.text.toString(), mVerifyCodeEt.text.toString())
        }
    }

    override fun onRegisterResult(success: Boolean) {
        toast("register " + (if(success)  "success" else "failed"))
    }
}
