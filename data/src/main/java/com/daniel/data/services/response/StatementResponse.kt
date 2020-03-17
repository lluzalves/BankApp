package com.daniel.data.services.response

import com.daniel.data.entities.Error
import com.daniel.data.entities.StatementEntity
import com.google.gson.annotations.SerializedName

data class StatementResponse(
    @SerializedName(STATEMENT)
    var statementList: List<StatementEntity>,
    @SerializedName(ERROR)
    var error: Error
) {
    companion object {
        const val STATEMENT = "statementList"
        const val ERROR = "error"
    }
}