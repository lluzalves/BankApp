package com.daniel.bankapp.di

import com.daniel.bankapp.ui.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val applicationModule = module(override = true) {
    viewModel { LoginViewModel() }
}

