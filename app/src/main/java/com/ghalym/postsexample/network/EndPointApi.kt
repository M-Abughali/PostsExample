package com.ghalym.postsexample.network

import com.ghalym.postsexample.ui.Posts.data.Post
import retrofit2.Call
import retrofit2.http.GET

interface EndPointApi {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>;
}