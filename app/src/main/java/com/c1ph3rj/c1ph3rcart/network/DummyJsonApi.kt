package com.c1ph3rj.c1ph3rcart.network

import com.c1ph3rj.c1ph3rcart.network.api.ApiRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DummyJsonApi {

    private const val BASE_URL = "https://dummyjson.com/"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    val retrofitService: ApiRequest by lazy {
        retrofit.create(ApiRequest::class.java)
    }

}

