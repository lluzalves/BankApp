package com.daniel.bankapp.di

import android.accounts.AccountManager
import com.daniel.bankapp.ui.login.LoginViewModel
import com.daniel.bankapp.ui.statements.StatementsOverviewViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val applicationModule = module(override = true) {
    viewModel { LoginViewModel() }
    viewModel { StatementsOverviewViewModel() }
    single { AccountManager.get(androidContext()) }
}

