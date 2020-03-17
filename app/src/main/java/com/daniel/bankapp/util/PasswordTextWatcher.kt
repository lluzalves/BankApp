package com.daniel.bankapp.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.daniel.bankapp.R
import com.daniel.bankapp.util.DataValidator.validatePassword
import org.koin.core.KoinComponent
import org.koin.core.inject


class PasswordTextWatcher constructor(private val passwordEditText: EditText) : TextWatcher,
    KoinComponent {
    private val context: Context by inject()
    var isPasswordInputCorrect = false

    override fun afterTextChanged(s: Editable) {
        if (!validatePassword(passwordEditText.text.toString())) {
            isPasswordInputCorrect = false
            passwordEditText.error = context.getString(R.string.error_password)
        } else {
            isPasswordInputCorrect = true
        }
    }


    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}