package com.ghalym.postsexample.ui.Posts.data

import com.ghalym.postsexample.network.EndPointApi
import com.ghalym.postsexample.network.RetrofitConnection
import com.ghalym.postsexample.ui.Posts.presenter.IPostPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository() {
    val endPointApi: EndPointApi;

    init {
        endPointApi = RetrofitConnection().endPointApi;
    }


    fun getAllPosts(iPostPresenter: IPostPresenter) {

        endPointApi.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                iPostPresenter?.onFail(t.message.toString())
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                iPostPresenter?.onSuccess(response.body())
            }

        })
    }


}