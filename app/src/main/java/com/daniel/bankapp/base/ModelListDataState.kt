package com.daniel.bankapp.base

data class ModelListDataState<T>(
    var state: DataState,
    var data: List<T>,
    var isLoadingInProgress: Boolean = false,
    var errorMessage: String?
)