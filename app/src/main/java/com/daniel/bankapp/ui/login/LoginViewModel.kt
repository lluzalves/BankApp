package com.daniel.bankapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniel.bankapp.base.DataState
import com.daniel.bankapp.base.ModelDataState
import com.daniel.commons.applyScheduler
import com.daniel.domain.dto.UserAccount
import com.daniel.domain.usecases.LoginUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val useCase: LoginUseCase by inject()
    private val _value = MutableLiveData<ModelDataState<UserAccount>>()
    val value: LiveData<ModelDataState<UserAccount>>
        get() = _value

    private val compositeDisposable = CompositeDisposable()

    fun onStart() {
        emmitState(DataState.INITIAL, null, null)
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }

     fun onLoginRequest(userName: String, password: String) {
        compositeDisposable.add(useCase.getUserAccount(userName, password)
            .applyScheduler()
            .subscribeBy { userAccount ->
                emmitState(DataState.COMPLETED, userAccount, null)
            })
    }

    private fun emmitState(dataState: DataState, user: UserAccount?, errorMessage: String?) {
        when (dataState) {
            DataState.COMPLETED -> {
                val loginData = ModelDataState(
                    state = DataState.COMPLETED,
                    data = user,
                    isLoadingInProgress = false,
                    errorMessage = null
                )
                _value.value = loginData
            }
            DataState.LOADING -> {
                val loginData = ModelDataState(
                    state = DataState.LOADING,
                    data = user,
                    isLoadingInProgress = true,
                    errorMessage = null
                )
                _value.value = loginData
            }
            DataState.FAILED -> {
                val loginData = ModelDataState(
                    state = DataState.FAILED,
                    data = user,
                    isLoadingInProgress = false,
                    errorMessage = errorMessage
                )
                _value.value = loginData
            }
            DataState.INITIAL -> {
                val loginData = ModelDataState(
                    state = DataState.INITIAL,
                    data = user,
                    isLoadingInProgress = true,
                    errorMessage = null
                )
                _value.value = loginData
            }
        }
    }
}