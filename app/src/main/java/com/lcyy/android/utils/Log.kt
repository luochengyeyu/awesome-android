package com.lcyy.android.utils

import android.util.Log

fun log(msg: String) = Log.d("Log","[${Thread.currentThread().name}] $msg")