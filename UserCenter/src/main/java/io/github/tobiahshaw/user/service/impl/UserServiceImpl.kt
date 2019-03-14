package io.github.tobiahshaw.user.service.impl

import io.github.tobiahshaw.base.ext.convertBoolean
import io.github.tobiahshaw.user.data.repository.UserRepository
import io.github.tobiahshaw.user.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var repository : UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode)
            .convertBoolean()
    }
}