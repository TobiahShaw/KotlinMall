package io.github.tobiahshaw.user.service.impl

import io.github.tobiahshaw.user.service.UserService
import io.reactivex.Observable
import java.util.*

class UserServiceImpl : UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(Random().nextBoolean())
    }
}