package com.example.instagram_sis1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram_sis1.adapters.PostAdapter
import com.example.instagram_sis1.adapters.StoryAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find RecyclerViews
        val storiesRecyclerView = findViewById<RecyclerView>(R.id.storiesRecyclerView)
        val postsRecyclerView = findViewById<RecyclerView>(R.id.postsRecyclerView)

        // Set layout managers
        storiesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        postsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Sample story data from your original file
        val stories = listOf(
            Story(1, "Your story", R.drawable.avatar1),
            Story(2, "OfficeMeow", R.drawable.avatar2),
            Story(3, "CuteHam", R.drawable.avatar3),
            Story(4, "dIvA", R.drawable.avatar1)
        )

        // Sample post data from your original file
        val posts = listOf(
            Post(1, "orange_cat", R.drawable.avatar2, R.drawable.post1, "Hello, World… Meow!", 1000000),
            Post(2, "PurrfectReader", R.drawable.avatar2, R.drawable.post2, "Look at this div-a", 42),
            Post(3, "NewsMem", R.drawable.avatar3, R.drawable.post3, "Breaking mews: sunsets still beautiful.", 20000000)
        )

        // Attach adapters
        storiesRecyclerView.adapter = StoryAdapter(stories)
        postsRecyclerView.adapter = PostAdapter(posts)
    }
}


