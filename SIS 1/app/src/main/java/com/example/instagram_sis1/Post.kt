package com.example.instagram_sis1

data class Post(
    val id: Long,
    val username: String,
    val avatarRes: Int,
    val imageRes: Int,
    val caption: String,
    val likes: Int
)
