package com.daniel.data.entities

import com.google.gson.annotations.SerializedName


data class StatementEntity(
    @SerializedName(TITLE)
    var title: String,
    @SerializedName(DESCRIPTION)
    var description: String,
    @SerializedName(DATE)
    var date: String,
    @SerializedName(VALUE)
    var value: Double
) {
    companion object {
        const val TITLE = "title"
        const val DESCRIPTION = "desc"
        const val DATE = "date"
        const val VALUE = "value"
    }
}