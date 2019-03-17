package io.github.tobiahshaw.base.ui.activity

import android.os.Bundle
import io.github.tobiahshaw.base.common.BaseApplication
import io.github.tobiahshaw.base.injection.component.ActivityComponent
import io.github.tobiahshaw.base.injection.component.DaggerActivityComponent
import io.github.tobiahshaw.base.injection.module.ActivityModule
import io.github.tobiahshaw.base.injection.module.LifecycleProviderModule
import io.github.tobiahshaw.base.presenter.BasePresenter
import io.github.tobiahshaw.base.presenter.view.BaseView
import io.github.tobiahshaw.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()

        injectComponent()

        mLoadingDialog = ProgressLoading.create(this)
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this)).lifecycleProviderModule(LifecycleProviderModule(this)).build()
    }

    override fun showLoading() {
        mLoadingDialog.show()
    }

    override fun hideLoading() {
        mLoadingDialog.dismiss()
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToast(msg: String) {
        toast(msg)
    }
}