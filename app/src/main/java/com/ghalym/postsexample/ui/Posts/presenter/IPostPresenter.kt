package com.ghalym.postsexample.ui.Posts.presenter

import com.ghalym.postsexample.ui.Posts.data.Post


interface IPostPresenter {
    fun onSuccess(list: List<Post>?);
    fun onFail(msg: String);
}