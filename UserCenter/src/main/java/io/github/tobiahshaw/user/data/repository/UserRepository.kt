package io.github.tobiahshaw.user.data.repository

import io.github.tobiahshaw.base.data.net.RetrofitFactory
import io.github.tobiahshaw.base.data.protocol.BaseResp
import io.github.tobiahshaw.user.data.api.UserAPI
import io.github.tobiahshaw.user.data.protocol.RegisterReq
import io.reactivex.Observable

class UserRepository {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserAPI::class.java).register(RegisterReq(mobile, pwd, verifyCode))
    }
}