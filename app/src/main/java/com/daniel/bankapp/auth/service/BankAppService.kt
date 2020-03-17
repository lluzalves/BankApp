package com.daniel.bankapp.auth.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.daniel.bankapp.auth.BankAppAccountAuthenticator

class BankAppService : Service() {
    private lateinit var authenticator: BankAppAccountAuthenticator
    override fun onBind(intent: Intent?): IBinder? {
        authenticator = BankAppAccountAuthenticator(context = this)
        return authenticator.iBinder
    }
}