package com.lcyy.android.feature.retrofit.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://www.wanandroid.com"
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(ApiCallAdapterFactory())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}