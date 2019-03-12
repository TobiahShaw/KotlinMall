package io.github.tobiahshaw.user.data.api

import io.github.tobiahshaw.base.data.protocol.BaseResp
import io.github.tobiahshaw.user.data.protocol.RegisterReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("userCenter/register")
    fun register(@Body req: RegisterReq) : Observable<BaseResp<String>>

}