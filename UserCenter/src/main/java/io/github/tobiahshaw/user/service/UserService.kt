package io.github.tobiahshaw.user.service

import io.reactivex.Observable

interface UserService {
    fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean>
}