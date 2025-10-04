package com.example.newsapp_sis2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp_sis2.adapters.PostAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postsRecyclerView = findViewById<RecyclerView>(R.id.postsRecyclerView)

        val postAdapter = PostAdapter { postId ->
            viewModel.onLikeClicked(postId)
        }

        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = postAdapter

        lifecycleScope.launch {
            viewModel.posts.collect { postsFromViewModel ->
                postAdapter.updatePosts(postsFromViewModel)
            }
        }
    }
}

