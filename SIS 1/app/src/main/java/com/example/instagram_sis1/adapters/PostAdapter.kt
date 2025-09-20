package com.example.instagram_sis1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram_sis1.Post
import com.example.instagram_sis1.R

class PostAdapter(
    private val posts: List<Post>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.postAvatar)
        val username: TextView = itemView.findViewById(R.id.postUsername)
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val caption: TextView = itemView.findViewById(R.id.captionText)
        val likes: TextView = itemView.findViewById(R.id.likesText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item, parent, false) // your post item layout
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.avatar.setImageResource(post.avatarRes)
        holder.username.text = post.username
        holder.postImage.setImageResource(post.imageRes)
        holder.caption.text = post.caption
        holder.likes.text = "${post.likes} likes"
    }

    override fun getItemCount(): Int = posts.size
}
