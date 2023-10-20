package com.lycc.arch.mvp.base

interface BaseView<T> {
    fun setPresenter(presenter: T)
}