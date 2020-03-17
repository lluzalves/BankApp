package com.daniel.data.entities

import com.google.gson.annotations.SerializedName


data class UserAccountEntity(
    @SerializedName(USER_ID)
    var userId: Int,
    @SerializedName(NAME)
    var name: String,
    @SerializedName(BANK_ACCOUNT)
    var bankAccount: String,
    @SerializedName(AGENCY)
    var agency: String,
    @SerializedName(BALANCE)
    var balance: Double
) {
    companion object {
        const val USER_ID = "userId"
        const val NAME = "name"
        const val BANK_ACCOUNT = "bankAccount"
        const val AGENCY = "agency"
        const val BALANCE = "balance"
    }
}