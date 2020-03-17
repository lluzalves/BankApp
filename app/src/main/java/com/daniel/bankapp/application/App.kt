package com.daniel.bankapp.application

import android.app.Application
import com.daniel.bankapp.di.applicationModule
import com.daniel.data.di.dataModule
import com.daniel.data.di.networkModule
import com.daniel.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    applicationModule,
                    domainModule,
                    dataModule,
                    networkModule
                )
            )
        }
    }
}