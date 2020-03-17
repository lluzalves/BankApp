package com.daniel.data.entities

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName(CODE)
    var code: String,
    @SerializedName(MESSAGE)
    var message: String
) {
    companion object {
        const val CODE = "code"
        const val MESSAGE = "message"
    }
}
