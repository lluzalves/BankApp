package com.daniel.data.services

import com.daniel.data.services.Urls.Companion.LOGIN_REQUEST
import com.daniel.data.services.Urls.Companion.STATEMENTS_REQUEST
import com.daniel.data.services.response.StatementResponse
import com.daniel.data.services.response.UserAccountResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

const val USER = "user"
const val PASSWORD = "password"

interface BankService {
    @FormUrlEncoded
    @POST(LOGIN_REQUEST)
    fun login(
        @Field(USER) name: String,
        @Field(PASSWORD) password: String
    ): Single<UserAccountResponse>

    @GET(STATEMENTS_REQUEST)
    fun getStatements(): Single<StatementResponse>
}