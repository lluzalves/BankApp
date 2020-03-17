package com.daniel.bankapp.auth

import android.accounts.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.daniel.bankapp.ui.MainActivity
import org.koin.core.KoinComponent


class BankAppAccountAuthenticator constructor(private val context: Context) :
    AbstractAccountAuthenticator(context), KoinComponent {

    @Throws(NetworkErrorException::class)
    override fun addAccount(
        response: AccountAuthenticatorResponse,
        accountType: String,
        authTokenType: String,
        requiredFeatures: Array<String>,
        options: Bundle
    ): Bundle {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra(AccountManager.KEY_ACCOUNT_TYPE, accountType)
        intent.putExtra(Auth.ARG_IS_ADDING_NEW_ACCOUNT, true)
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)
        val bundle = Bundle()
        bundle.putParcelable(AccountManager.KEY_INTENT, intent)
        return bundle
    }

    @Throws(NetworkErrorException::class)
    override fun getAuthToken(
        response: AccountAuthenticatorResponse,
        account: Account,
        authTokenType: String,
        options: Bundle
    ): Bundle? {
        return null
    }

    override fun getAuthTokenLabel(s: String): String {
        return "full"
    }

    @Throws(NetworkErrorException::class)
    override fun confirmCredentials(
        accountAuthenticatorResponse: AccountAuthenticatorResponse,
        account: Account,
        bundle: Bundle
    ): Bundle? {
        return null
    }

    @Throws(NetworkErrorException::class)
    override fun hasFeatures(
        accountAuthenticatorResponse: AccountAuthenticatorResponse,
        account: Account,
        strings: Array<String>
    ): Bundle? {
        return null
    }

    override fun editProperties(
        response: AccountAuthenticatorResponse?,
        accountType: String?
    ): Bundle? {
        return null
    }

    @Throws(NetworkErrorException::class)
    override fun updateCredentials(
        accountAuthenticatorResponse: AccountAuthenticatorResponse,
        account: Account,
        s: String,
        bundle: Bundle
    ): Bundle? {
        return null
    }

}