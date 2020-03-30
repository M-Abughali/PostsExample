package com.ghalym.postsexample.ui.Posts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghalym.postsexample.R
import com.ghalym.postsexample.ui.Posts.data.Post
import com.ghalym.postsexample.ui.Posts.presenter.Presenter
import kotlinx.android.synthetic.main.display_posts_activity.*

class DisplayPostsActivity : AppCompatActivity(),
    OnItemClickListener, IPostView {

    var data: MutableList<Post> = mutableListOf<Post>();
    var adapter: PostRecyclerAdapter? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_posts_activity)
        rvPosts.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = PostRecyclerAdapter(data);
        adapter!!.onClickListener = this;
        rvPosts.adapter = adapter;
        var presenter = Presenter(this);
        presenter.getPostsFromRepo();

    }

    override fun onItemClick(position: Int) {

        Toast.makeText(this, "You Pressed At Position  " + position, Toast.LENGTH_LONG).show();
    }

    override fun showLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loader.visibility = View.GONE
    }

    override fun showError(msg: String) {
        Toast.makeText(this, "Error : " + msg, Toast.LENGTH_LONG).show();
    }

    override fun showResult(list: List<Post>?) {
        this.data.addAll(list!!.toMutableList())
        adapter!!.notifyDataSetChanged();
    }
}
