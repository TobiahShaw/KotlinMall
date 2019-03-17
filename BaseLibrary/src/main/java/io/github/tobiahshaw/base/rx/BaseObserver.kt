package io.github.tobiahshaw.base.rx

import io.github.tobiahshaw.base.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open class BaseObserver<T> constructor(val baseView: BaseView) : Observer<T> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
        baseView.showLoading()
    }

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
    }

}