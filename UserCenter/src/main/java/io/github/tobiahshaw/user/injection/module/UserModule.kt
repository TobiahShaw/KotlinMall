package io.github.tobiahshaw.user.injection.module

import dagger.Module
import dagger.Provides
import io.github.tobiahshaw.user.service.UserService
import io.github.tobiahshaw.user.service.impl.UserServiceImpl

@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl) : UserService {
        return service
    }
}