package io.github.tobiahshaw.base.ext

import android.view.View
import com.trello.rxlifecycle2.LifecycleProvider
import io.github.tobiahshaw.base.data.protocol.BaseResp
import io.github.tobiahshaw.base.rx.BaseFunc
import io.github.tobiahshaw.base.rx.BaseFuncBoolean
import io.github.tobiahshaw.base.rx.BaseObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.execute(observer : BaseObserver<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
        .compose(lifecycleProvider.bindToLifecycle())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun View.onClick(method : (View) -> Unit) {
    this.setOnClickListener{method(it)}
}

fun <T> Observable<BaseResp<T>>.convert() : Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean() : Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}