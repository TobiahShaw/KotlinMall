package io.github.tobiahshaw.base.presenter

import android.content.Context
import io.github.tobiahshaw.base.utils.NetWorkUtils
import com.trello.rxlifecycle2.LifecycleProvider
import io.github.tobiahshaw.base.presenter.view.BaseView
import javax.inject.Inject

open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork() : Boolean {
        return NetWorkUtils.isNetWorkAvailable(context)
    }
}