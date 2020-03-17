package com.daniel.domain.di

import com.daniel.domain.usecases.LoginUseCase
import org.koin.dsl.module

val domainModule = module(override = true) {
    factory { LoginUseCase() }
}