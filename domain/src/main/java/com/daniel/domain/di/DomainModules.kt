package com.daniel.domain.di

import com.daniel.domain.usecases.StatementsUseCase
import com.daniel.domain.usecases.UserAccountUseCase
import org.koin.dsl.module

val domainModule = module(override = true) {
    factory { UserAccountUseCase() }
    factory { StatementsUseCase() }
}