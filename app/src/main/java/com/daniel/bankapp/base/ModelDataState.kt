package com.daniel.bankapp.base

data class ModelDataState<T>(
    var state: DataState,
    var data: T?,
    var isLoadingInProgress: Boolean = false,
    var errorMessage: String?
)