package com.ghalym.postsexample.ui.Posts.presenter

import android.util.Log
import com.ghalym.postsexample.ui.Posts.data.Post
import com.ghalym.postsexample.ui.Posts.data.PostRepository
import com.ghalym.postsexample.ui.Posts.view.IPostView

class Presenter(val iPostView: IPostView, val postRepository: PostRepository) : IPostPresenter {




    fun getPostsFromRepo() {
        iPostView.showLoading();
        postRepository.getAllPosts(this);
    }


    override fun onSuccess(list: List<Post>?) {
        iPostView.hideLoading()
        iPostView.showResult(list);

    }

    override fun onFail(msg: String) {
        iPostView.hideLoading()
        iPostView.showError(msg)
    }


}