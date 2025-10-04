package com.example.newsapp_sis2.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp_sis2.Post
import com.example.newsapp_sis2.R

class PostAdapter(
    private val onLikeClicked: (Int) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts: List<Post> = emptyList()

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.postAvatar)
        val username: TextView = itemView.findViewById(R.id.postUsername)
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val caption: TextView = itemView.findViewById(R.id.captionText)
        val likes: TextView = itemView.findViewById(R.id.likesText)
        val likeButton: ImageView = itemView.findViewById(R.id.likeButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        val context = holder.itemView.context

        holder.username.text = post.username
        holder.caption.text = post.caption
        Glide.with(context).load(post.userAvatarUrl).into(holder.avatar)
        Glide.with(context).load(post.postImageUrl).into(holder.postImage)

        holder.likes.text = "${post.likes} likes"
        if (post.isLiked) {
            holder.likeButton.setImageResource(R.drawable.ic_heart_filled)
            holder.likeButton.setColorFilter(ContextCompat.getColor(context, R.color.liked_red))
        } else {
            holder.likeButton.setImageResource(R.drawable.ic_heart)
            holder.likeButton.clearColorFilter()
        }

        holder.likeButton.setOnClickListener {
            onLikeClicked(post.id)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatePosts(newPosts: List<Post>) {
        this.posts = newPosts
        notifyDataSetChanged()
    }
}