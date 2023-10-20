package com.lcyy.android.feature.jetpack

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "SharedViewModel"

class SharedViewModel : ViewModel() {
    private var _count = MutableLiveData(0)
    val count: LiveData<Int>
        get() = _count

    fun view() {
        _count.value = _count.value?.inc()
        Log.d(TAG, "view(): ${_count.value.toString()}")
    }
}