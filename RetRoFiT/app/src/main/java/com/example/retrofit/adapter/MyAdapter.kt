package com.example.retrofit.adapter

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlin.coroutines.coroutineContext

class MyAdapter(
    private val myList: List<Post>
): RecyclerView.Adapter<MyAdapter.MyViewHolder> (){
     inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val post = myList[position]
        holder.itemView.apply {
            albumId_txt.text = post.albumId.toString()
            id_txt.text = post.id.toString()
            title_txt.text = post.title
            Glide.with(this).load("https://robohash.org/${post.id}/set=set1").into(url_txt)
            Glide.with(this).load("https://robohash.org/${post.id}/set=set2").into(thumbnailUrl_txt)
        }
    }
}