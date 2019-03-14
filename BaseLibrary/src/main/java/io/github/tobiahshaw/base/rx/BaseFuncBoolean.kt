package io.github.tobiahshaw.base.rx

import io.github.tobiahshaw.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFuncBoolean : Function<BaseResp<*>, Observable<Boolean>> {
    override fun apply(it: BaseResp<*>): Observable<Boolean> {
        return if (it.status != 0) {
            Observable.error(BaseException(it.status, it.message))
        } else {
            Observable.just(true)
        }
    }
}