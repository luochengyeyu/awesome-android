package com.lcyy.android.feature.retrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcyy.android.feature.retrofit.data.api.ApiResult
import com.lcyy.android.feature.retrofit.data.api.RetrofitBuilder
import kotlinx.coroutines.launch

class RetrofitViewModel : ViewModel() {
    private var _json : MutableLiveData<String> = MutableLiveData("")
    val json = _json

    init {
        getBanners()
    }
    fun getBanners() {
        viewModelScope.launch {
            val apiResult = RetrofitBuilder.apiService.getBanners()
            if (apiResult is ApiResult.Success) {
                _json.value = apiResult.data.toString()
            }
        }
    }
}