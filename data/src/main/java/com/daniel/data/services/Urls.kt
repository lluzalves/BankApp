package com.daniel.data.services

class Urls {

    object BankApi {
        const val BASE_URL = "https://bank-app-test.herokuapp.com/api/"
        const val STATEMENT = "statements"
        const val USER_ID = "idUser"
        const val USER_ID_URL = "/{idUser}"
        const val LOGIN = "login"
    }

    companion object {
        const val LOGIN_REQUEST = BankApi.BASE_URL.plus(BankApi.LOGIN)
        const val STATEMENTS_REQUEST = BankApi.STATEMENT.plus(BankApi.USER_ID_URL)
    }
}