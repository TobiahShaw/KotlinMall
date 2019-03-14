package io.github.tobiahshaw.base.rx

import io.github.tobiahshaw.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(it: BaseResp<T>): Observable<T> {
        return if (it.status != 0) {
            Observable.error(BaseException(it.status, it.message))
        } else {
            Observable.just(it.data)
        }
    }
}