package com.daniel.bankapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.daniel.bankapp.R
import kotlinx.android.synthetic.main.login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(), View.OnClickListener {
    private val viewModel: LoginViewModel by viewModel()
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
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            btnLogin -> {
                val userName = userInput.text.toString()
                val password = passwordInput.text.toString()
                if (!userName.isNullOrBlank() && !password.isNullOrBlank()) {
                    viewModel.onLoginRequest(userName = userName, password = password)
                }
            }
        }
    }
}
