package io.github.tobiahshaw.base.ui.activity

import io.github.tobiahshaw.base.presenter.BasePresenter
import io.github.tobiahshaw.base.presenter.view.BaseView
import javax.inject.Inject

open class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}