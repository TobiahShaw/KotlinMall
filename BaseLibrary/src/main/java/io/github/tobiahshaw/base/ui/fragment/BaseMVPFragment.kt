package io.github.tobiahshaw.base.ui.fragment

import android.os.Bundle
import io.github.tobiahshaw.base.common.BaseApplication
import io.github.tobiahshaw.base.injection.component.ActivityComponent
import io.github.tobiahshaw.base.injection.component.DaggerActivityComponent
import io.github.tobiahshaw.base.injection.module.ActivityModule
import io.github.tobiahshaw.base.injection.module.LifecycleProviderModule
import io.github.tobiahshaw.base.presenter.BasePresenter
import io.github.tobiahshaw.base.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

abstract class BaseMVPFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()

        injectComponent()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((activity?.application as BaseApplication).appComponent)
            .activityModule(ActivityModule(activity!!)).lifecycleProviderModule(LifecycleProviderModule(this)).build()
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

    override fun showToast(msg: String) {
        toast(msg)
    }
}