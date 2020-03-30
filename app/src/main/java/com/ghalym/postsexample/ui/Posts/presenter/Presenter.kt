package com.ghalym.postsexample.ui.Posts.presenter

import android.util.Log
import android.widget.Toast
import com.ghalym.postsexample.ui.Posts.data.Post
import com.ghalym.postsexample.ui.Posts.data.PostRepo
import com.ghalym.postsexample.ui.Posts.view.IPostView

class Presenter(iPostView: IPostView) : IPostPresenter {

    var iPostView: IPostView;
    var postRepo: PostRepo;

    init {
        this.iPostView = iPostView;
        postRepo = PostRepo(this);
    }


    fun getPostsFromRepo() {
        iPostView.showLoading();
        postRepo.getAllPosts();
    }


    override fun onSuccess(list: List<Post>?) {
       Log.e("onSuccess","onSuccess");
        iPostView.hideLoading()
        iPostView.showResult(list);

    }

    override fun onFail(msg: String) {
        Log.e("onFail","onFail");
        iPostView.hideLoading()
        iPostView.showError(msg)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}