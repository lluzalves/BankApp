package com.daniel.bankapp.ui.login

import android.accounts.Account
import android.accounts.AccountManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.daniel.bankapp.R
import com.daniel.bankapp.auth.*
import com.daniel.bankapp.base.DataState
import com.daniel.bankapp.base.ModelDataState
import com.daniel.bankapp.util.PasswordTextWatcher
import com.daniel.bankapp.util.UserNameTextWatcher
import com.daniel.domain.dto.UserAccount
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.login.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModel()
    private val accountManager: AccountManager by inject()
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

        viewModel.value.observe(viewLifecycleOwner, Observer { loginDataState ->
            val dataState = loginDataState ?: return@Observer
            onDataStateChangeHandleViewState(dataState)
        })

        userInput.apply {
            userInputTextWatcher = UserNameTextWatcher(userNameEditText = this)
            addTextChangedListener(userInputTextWatcher)
            if (!accountManager.getAccountsByType(Auth.ARG_ACCOUNT_TYPE).isNullOrEmpty()) {
                this.setText(accountManager.getAccountsByType(Auth.ARG_ACCOUNT_TYPE)[0].name)
            }
        }

        passwordInput.apply {
            passwordTextWatcher = PasswordTextWatcher(passwordEditText = this)
            addTextChangedListener(passwordTextWatcher)
        }

        btnLogin.apply {
            setOnClickListener { view ->
                when {
                    userInputTextWatcher.isEmailInputCorrect && passwordTextWatcher.isPasswordInputCorrect -> {
                        viewModel.onLoginRequest(
                            userName = userInput.text.toString(),
                            password = userInput.text.toString()
                        )
                    }
                    else -> {
                        Snackbar.make(view, getString(R.string.warning), Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

    private fun onDataStateChangeHandleViewState(dataState: ModelDataState<UserAccount>) {
        when (dataState.state) {
            DataState.COMPLETED -> {
                progressBar.isVisible = false
                btnLogin.isVisible = true
                userInput.isVisible = true
                passwordInput.isVisible = true
                if (accountManager.getAccountsByType(Auth.ARG_ACCOUNT_TYPE).isNullOrEmpty()) {
                    val account = Account(userInput.text.toString(), Auth.ARG_ACCOUNT_TYPE)
                    val password = passwordInput.text.toString()
                    viewModel.addAccount(accountManager, account, password)
                }
            }
            DataState.LOADING -> {
                userInput.isVisible = false
                passwordInput.isVisible = false
                progressBar.isVisible = true
                btnLogin.isVisible = false
            }
            DataState.FAILED -> {
                btnLogin.isVisible = true
            }
            DataState.INITIAL -> {
            }
        }
    }

}
