package com.c1ph3rj.c1ph3rcart.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.c1ph3rj.c1ph3rcart.model.GetProductsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestManager {

    private val _getAllProductsResponse = mutableStateOf(GetProductsModel())
    val getAllProductsResponse: State<GetProductsModel>
    @Composable get() = remember {
        _getAllProductsResponse
    }



    fun getAllProducts(){
        val service = DummyJsonApi.retrofitService.getAllProducts()
        service.enqueue(object: Callback<GetProductsModel>{
            override fun onResponse(
                call: Call<GetProductsModel>,
                response: Response<GetProductsModel>
            ) {
                if(response.isSuccessful){
                    Log.i("Success", "${response.body()}")
                    if(response.body() != null){
                        _getAllProductsResponse.value = response.body()!!
                    }
                }else{
                    Log.i("Error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<GetProductsModel>, t: Throwable) {
                Log.i("Error", "${t.printStackTrace()}")
            }

        })
    }
}