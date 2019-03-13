package io.github.tobiahshaw.base.ui.activity

import android.os.Bundle
import io.github.tobiahshaw.base.common.BaseApplication
import io.github.tobiahshaw.base.injection.component.ActivityComponent
import io.github.tobiahshaw.base.injection.component.DaggerActivityComponent
import io.github.tobiahshaw.base.injection.module.ActivityModule
import io.github.tobiahshaw.base.injection.module.LifecycleProviderModule
import io.github.tobiahshaw.base.presenter.BasePresenter
import io.github.tobiahshaw.base.presenter.view.BaseView
import javax.inject.Inject

open class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this)).lifecycleProviderModule(LifecycleProviderModule(this)).build()
    }

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