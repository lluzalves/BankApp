package com.daniel.bankapp.util

import java.util.regex.Matcher
import java.util.regex.Pattern

object DataValidator {

    private val cpfRegex = "(\\d{3}.?\\d{3}.?\\d{3}-?\\d{2})"
    private val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\$"
    private var passwordRegex = "((?=.*\\d)(?=.*[A-Z])(?=.*\\W))"
    private lateinit var pattern: Pattern
    private lateinit var matcher: Matcher

    fun validateUserInput(userInput: String): Boolean {
        pattern = Pattern.compile(emailRegex)
        matcher = pattern.matcher(userInput)
        return if (matcher.matches()) {
            true
        } else {
            pattern = Pattern.compile(cpfRegex)
            matcher = pattern.matcher(userInput)
            matcher.matches()
        }
    }

    fun validatePassword(password: String): Boolean {
        pattern = Pattern.compile(passwordRegex)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }
}