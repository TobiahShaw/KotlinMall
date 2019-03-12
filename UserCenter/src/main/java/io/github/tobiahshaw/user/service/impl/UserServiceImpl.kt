package io.github.tobiahshaw.user.service.impl

import io.github.tobiahshaw.base.rx.BaseException
import io.github.tobiahshaw.user.data.repository.UserRepository
import io.github.tobiahshaw.user.service.UserService
import io.reactivex.Observable

class UserServiceImpl : UserService {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        val repository = UserRepository()
        return repository.register(mobile, pwd, verifyCode)
            .flatMap {
                if (it.status != 0) {
                    Observable.error(BaseException(it.status, it.message))
                } else {
                    Observable.just(true)
                }
            }
    }
}