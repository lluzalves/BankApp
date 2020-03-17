package com.daniel.bankapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.daniel.bankapp.R
import com.daniel.bankapp.util.PasswordTextWatcher
import com.daniel.bankapp.util.UserNameTextWatcher
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModel()
    private lateinit var userInputTextWatcher: UserNameTextWatcher
    private lateinit var passwordTextWatcher: PasswordTextWatcher

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userInput.apply {
            userInputTextWatcher = UserNameTextWatcher(userNameEditText = this)
            addTextChangedListener(userInputTextWatcher)
        }

        passwordInput.apply {
            passwordTextWatcher = PasswordTextWatcher(passwordEditText = this)
            addTextChangedListener(passwordTextWatcher)
        }

        btnLogin.apply {
            setOnClickListener { view ->
                if (userInputTextWatcher.isEmailInputCorrect && passwordTextWatcher.isPasswordInputCorrect) {
                    viewModel.onLoginRequest(
                        userName = userInput.text.toString(),
                        password = userInput.text.toString()
                    )
                } else {
                    Snackbar.make(view, getString(R.string.warning), Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

}
