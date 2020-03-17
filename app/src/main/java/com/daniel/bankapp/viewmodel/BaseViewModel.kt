package com.daniel.bankapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniel.bankapp.base.DataState
import com.daniel.bankapp.base.ModelListDataState
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.KoinComponent

abstract class BaseViewModel<T> : ViewModel(), KoinComponent {
    private val _value = MutableLiveData<ModelListDataState<T>>()
    val value: LiveData<ModelListDataState<T>>
        get() = _value

    protected val compositeDisposable  = CompositeDisposable()

    abstract fun onStart()
    abstract fun onDestroy()
    abstract fun recoverState()
    abstract fun emmitState(dataState : DataState, data: List<T>?, errorMessage : String)
}