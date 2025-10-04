package com.example.newsapp_sis2

data class Post(
    val id: Int,
    val username: String,
    val userAvatarUrl: String,
    val postImageUrl: String,
    val caption: String,
    var likes: Int,
    var isLiked: Boolean = false
)