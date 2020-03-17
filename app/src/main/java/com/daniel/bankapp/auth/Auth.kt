package com.daniel.bankapp.auth


object Auth{
    const val ARG_ACCOUNT_TYPE = "com.daniel.bankapp"
    const val ARG_AUTH_TYPE ="AUTH_TOKEN_TYPE"
    const val ARG_IS_ADDING_NEW_ACCOUNT = "IS_NEW_ACCOUNT"
    const val ACCOUNT_NAME = "BankAppAccount"
}

object Access {
    const val AUTH_TOKEN_TYPE_READ_ONLY = "Read Only"
    const val AUTH_TOKEN_TYPE_READ_ONLY_LABEL = "Read only access to DD account"
    const val AUTH_TOKEN_FULL_ACCESS = "Full Access"
    const val AUTH_TOKEN_FULL_ACCESS_LABEL = "Full access to DD account"
}

object Parse {
    const val PARAMETER_USERNAME = "username"
    const val PARAMETER_PASSWORD = "password"
}