package com.lcyy.android.feature.retrofit.data.api

import com.lcyy.android.feature.retrofit.data.model.Banner
import retrofit2.http.GET

interface ApiService {
    @GET("/banner/json")
    suspend fun getBanners(): ApiResult<ApiResponse<List<Banner>>>

}