package com.daniel.domain.repositories.usersaccounts

import com.daniel.domain.dto.UserAccount
import io.reactivex.Single

interface UserAccountRepository {
    fun fetchUserInfo(userName:String, password : String) : Single<UserAccount>
}