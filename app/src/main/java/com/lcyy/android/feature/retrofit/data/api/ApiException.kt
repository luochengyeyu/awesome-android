package com.lcyy.android.feature.retrofit.data.api

class ApiException : Exception {
    var errorCode: Int
        private set
    var errorMessage: String
        private set

    constructor(code: Int, message: String) {
        errorCode = code
        errorMessage = message
    }

    constructor(code: Int, message: String, e: Throwable?) : super(e) {
        errorCode = code
        errorMessage = message
    }

    companion object {
        private const val ERROR_CODE_DATA_PARSE = 20001
        private const val ERROR_CODE_SEVER_ERROR = 20002
        private const val ERROR_CODE_NET_ERROR = 20003
        val PARSE_ERROR = ApiException(ERROR_CODE_DATA_PARSE, "数据解析出错")
        val SERVER_ERROR = ApiException(ERROR_CODE_SEVER_ERROR, "服务器响应出错")
        val NET_ERROR = ApiException(ERROR_CODE_NET_ERROR, "网络连接出错")
    }
}
