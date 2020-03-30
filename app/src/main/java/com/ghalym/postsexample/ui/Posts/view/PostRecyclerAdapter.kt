package com.ghalym.postsexample.ui.Posts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ghalym.postsexample.R
import com.ghalym.postsexample.ui.Posts.data.Post
import kotlinx.android.synthetic.main.item.view.*

class PostRecyclerAdapter(data: List<Post>?) : RecyclerView.Adapter<PostRecyclerAdapter.MyViewHolder>() {
    var data: List<Post>?

    init {
        this.data = data;
    }

    var onClickListener: OnItemClickListener? = null;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        var viewHolder: MyViewHolder = MyViewHolder(view);
        return viewHolder;
    }

    override fun getItemCount(): Int {
        return data!!.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.t1.text = data!![position].id.toString()
        holder.t2.text = data!![position].title
    }


    inner class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val t1 = view.t1 as TextView;
        val t2 = view.t2 as TextView;

        init {
            view.setOnClickListener {

                onClickListener?.onItemClick(adapterPosition);


            }
        }

    }
}
