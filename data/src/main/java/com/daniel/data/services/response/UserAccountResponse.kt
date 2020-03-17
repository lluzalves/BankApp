package com.daniel.data.services.response

import com.daniel.data.entities.Error
import com.daniel.data.entities.UserAccountEntity
import com.google.gson.annotations.SerializedName


class UserAccountResponse(
    @SerializedName(USER_ACCOUNT)
    var userAccount: UserAccountEntity,
    @SerializedName(ERROR)
    var error: Error
){
    companion object{
        const val USER_ACCOUNT = "userAccount"
        const val ERROR = "error"
    }
}