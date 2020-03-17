package com.daniel.data.repository

import com.daniel.commons.applyScheduler
import com.daniel.data.adapters.Adapter
import com.daniel.data.services.BankService
import com.daniel.domain.dto.UserAccount
import com.daniel.domain.repositories.usersaccounts.UserAccountRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class UserAccountRepositoryImpl : UserAccountRepository, KoinComponent {

    private val bankService: BankService by inject()

    override fun fetchUserInfo(userName : String, password : String): Single<UserAccount> {
        return bankService.login(userName,password)
            .applyScheduler()
            .map { response -> Adapter.toUserAccount(response.userAccount) }
    }
}