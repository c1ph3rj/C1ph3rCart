package com.c1ph3rj.c1ph3rcart.network.api

import com.c1ph3rj.c1ph3rcart.model.GetProductsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {
    @GET("products")
    fun getAllProducts():Call<GetProductsModel>
}