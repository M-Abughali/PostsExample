package com.ghalym.postsexample.ui.Posts.view

import com.ghalym.postsexample.ui.Posts.data.Post

interface IPostView {
    fun showLoading();
    fun hideLoading();
    fun showError(msg:String);
    fun showResult(list: List<Post>?);
}