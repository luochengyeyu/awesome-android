package com.lcyy.android.feature.retrofit.data.api

object ApiError {
    var unknownError = Error(20000, "unKnown error")
    var netError = Error(20001, "net error")
    var emptyData = Error(20002, "empty data")
}

data class Error(var errorCode: Int, var errorMsg: String)