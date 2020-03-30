package com.ghalym.postsexample.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnection {
    val retrofit: Retrofit;
    val endPointApi: EndPointApi;


    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        endPointApi = retrofit.create(EndPointApi::class.java);
    }

}