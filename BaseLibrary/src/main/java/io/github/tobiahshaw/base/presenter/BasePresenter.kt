package io.github.tobiahshaw.base.presenter

import io.github.tobiahshaw.base.presenter.view.BaseView

open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}