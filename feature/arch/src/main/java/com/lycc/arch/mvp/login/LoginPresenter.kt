package com.lycc.arch.mvp.login

import com.lycc.arch.mvp.login.model.User
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginPresenter(private var view: LoginContract.View?, private val model: LoginContract.Model) :
    LoginContract.Presenter {

    init {
        view?.setPresenter(this)
    }

    override fun login(username: String, password: String) {
        view?.showLoading()
        model.login(username, password, object : LoginContract.CallBack {
            override fun onLoginSuccess(user: User) {
                view?.hideLoading()
                view?.onLoginSuccess(user.toString())
            }

            override fun onLoginFailed() {
                view?.hideLoading()
                view?.onLoginSuccess("登录失败")
            }

        })
    }

    override fun start() {
    }

    override fun onDestroy() {
        view = null
    }
}