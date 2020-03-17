package com.daniel.bankapp.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.daniel.bankapp.R
import com.daniel.bankapp.util.DataValidator.validateUserInput
import org.koin.core.KoinComponent
import org.koin.core.inject


class UserNameTextWatcher constructor (private val userNameEditText : EditText): TextWatcher, KoinComponent {
    private val context: Context by inject()
    var isEmailInputCorrect = false

    override fun afterTextChanged(s: Editable) {
        if (!validateUserInput(userNameEditText.text.toString())) {
            userNameEditText.error = context.getString(R.string.error_invalid_email_or_cpf)
        } else {
            isEmailInputCorrect = true
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
}