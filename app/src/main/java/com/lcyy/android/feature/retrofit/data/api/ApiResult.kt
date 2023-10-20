package com.lcyy.android.feature.retrofit.data.api

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Failure(val errorCode: Int, val errorMsg: String) : ApiResult<Nothing>()
}

data class ApiResponse<out T>(var errorCode: Int, var errorMsg: String, val data: T)