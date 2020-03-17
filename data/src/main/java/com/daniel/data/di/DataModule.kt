package com.daniel.data.di

import com.daniel.data.network.NetworkFactory
import com.daniel.data.repository.StatementRepositoryImpl
import com.daniel.data.repository.UserAccountRepositoryImpl
import com.daniel.data.services.BankService
import com.daniel.data.services.Urls
import com.daniel.domain.repositories.statements.StatementRepository
import com.daniel.domain.repositories.usersaccounts.UserAccountRepository
import com.google.gson.GsonBuilder
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module(override = true) {
    factory<BankService> {
        NetworkFactory().webService(Urls.BankApi.BASE_URL).newBuilder().build()
            .create(BankService::class.java)
    }
}

val dataModule = module(override = true) {
    single {
        HttpLoggingInterceptor().apply {
            HttpLoggingInterceptor.Level.BODY
        }
    }
    single { return@single StatementRepositoryImpl() as StatementRepository }
    single { return@single UserAccountRepositoryImpl() as UserAccountRepository }
    single { GsonConverterFactory.create(GsonBuilder().create()) }
}