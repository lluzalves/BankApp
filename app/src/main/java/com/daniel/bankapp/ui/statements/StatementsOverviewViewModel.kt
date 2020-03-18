package com.daniel.bankapp.ui.statements

import com.daniel.bankapp.base.DataState
import com.daniel.bankapp.base.ModelListDataState
import com.daniel.bankapp.viewmodel.BaseViewModel
import com.daniel.commons.applyScheduler
import com.daniel.domain.dto.Statement
import com.daniel.domain.usecases.StatementsUseCase
import io.reactivex.rxkotlin.subscribeBy
import org.koin.core.KoinComponent
import org.koin.core.inject


class StatementsOverviewViewModel : BaseViewModel<Statement>(), KoinComponent {

    private val statementsUseCase: StatementsUseCase by inject()
    override fun onStart() {
        emmitState(DataState.INITIAL, null, null)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    fun getStatements(userId: String) {
        compositeDisposable.add(statementsUseCase.getStatements(userId = userId)
            .applyScheduler()
            .subscribeBy(
                onError = { error ->
                    emmitState(DataState.FAILED, null, error.localizedMessage)
                },
                onSuccess = { statements ->
                    emmitState(DataState.COMPLETED, statements, null)
                }
            ))
    }

    override fun emmitState(
        dataState: DataState,
        statements: List<Statement>?,
        errorMessage: String?
    ) {
        when (dataState) {
            DataState.COMPLETED -> {
                val statementsData = ModelListDataState(
                    state = DataState.COMPLETED,
                    data = statements,
                    isLoadingInProgress = false,
                    errorMessage = null
                )
                _value.value = statementsData
            }
            DataState.LOADING -> {
                val statementsData = ModelListDataState(
                    state = DataState.LOADING,
                    data = statements,
                    isLoadingInProgress = true,
                    errorMessage = null
                )
                _value.value = statementsData
            }
            DataState.FAILED -> {
                val statementsData = ModelListDataState(
                    state = DataState.FAILED,
                    data = statements,
                    isLoadingInProgress = false,
                    errorMessage = errorMessage
                )
                _value.value = statementsData
            }
            DataState.INITIAL -> {
                val statementsData = ModelListDataState(
                    state = DataState.INITIAL,
                    data = statements,
                    isLoadingInProgress = true,
                    errorMessage = null
                )
                _value.value = statementsData
            }
        }
    }

    override fun recoverState() {
        TODO("Not yet implemented")
    }
}
