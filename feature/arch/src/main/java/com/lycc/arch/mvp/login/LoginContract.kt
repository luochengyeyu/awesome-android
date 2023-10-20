package com.lycc.arch.mvp.login

import com.lycc.arch.mvp.base.BasePresenter
import com.lycc.arch.mvp.base.BaseView
import com.lycc.arch.mvp.login.model.User

interface LoginContract {

    interface Presenter : BasePresenter {
        fun login(username: String, password: String)
    }

    interface View : BaseView<Presenter> {
        fun showLoading()
        fun hideLoading()
        fun onLoginSuccess(result: String)
        fun onLoginFailed(result: String)
    }

    interface Model {
        fun login(username: String, password: String, callBack: CallBack)
    }

    interface CallBack {
        fun onLoginSuccess(user: User)

        fun onLoginFailed()
    }
}