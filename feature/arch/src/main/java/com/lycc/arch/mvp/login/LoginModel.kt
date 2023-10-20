package com.lycc.arch.mvp.login

import com.lycc.arch.mvp.login.model.User
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginModel : LoginContract.Model {
    override fun login(username: String, password: String, callBack: LoginContract.CallBack) {
        MainScope().launch {
            // 模拟网络请求
            delay(2000)
            if (password == "password") {
                callBack.onLoginSuccess(User("123", "https://g.cn/123.png"))
            } else {
                callBack.onLoginFailed()
            }
        }
    }
}