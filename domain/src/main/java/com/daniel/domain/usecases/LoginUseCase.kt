package com.daniel.domain.usecases

import com.daniel.domain.dto.UserAccount
import com.daniel.domain.repositories.usersaccounts.UserAccountRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginUseCase : KoinComponent {
    private val userAccountRepository: UserAccountRepository by inject()

    fun getUserAccount(userName: String, password: String): Single<UserAccount> {
        return userAccountRepository.fetchUserInfo(userName, password)
    }
}