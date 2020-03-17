package com.daniel.data.services

class Urls {

    object BankApi {
        const val BASE_URL = "https://bank-app-test.herokuapp.com/api/"
        const val STATEMENT = "statements"
        const val LOGIN = "login"
    }

    companion object {
        const val LOGIN_REQUEST = BankApi.BASE_URL.plus(BankApi.LOGIN)
        const val STATEMENTS_REQUEST = BankApi.STATEMENT.plus(BankApi.STATEMENT)
    }
}