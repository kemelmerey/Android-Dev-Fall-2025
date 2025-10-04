package com.example.newsapp_sis2

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class PostViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val POSTS_STATE_KEY = "posts_state"
    }

    val posts: StateFlow<List<Post>> = savedStateHandle.getStateFlow(POSTS_STATE_KEY, generateMockData())

    fun onLikeClicked(postId: Int) {
        val currentPosts = posts.value.toMutableList()
        val postIndex = currentPosts.indexOfFirst { it.id == postId }

        if (postIndex != -1) {
            val oldPost = currentPosts[postIndex]

            val newPost = if (oldPost.isLiked) {
                oldPost.copy(likes = oldPost.likes - 1, isLiked = false)
            } else {
                oldPost.copy(likes = oldPost.likes + 1, isLiked = true)
            }
            currentPosts[postIndex] = newPost

            savedStateHandle[POSTS_STATE_KEY] = currentPosts
        }
    }

    private fun generateMockData(): List<Post> {
        return listOf(
            Post(
                id = 1,
                username = "orange_cat",
                userAvatarUrl = "https://res.cloudinary.com/dhbb2ehoi/image/upload/v1758966630/b04c3d0169e52a7f7a9ad48c8a87701a_bfqv8x.avif",
                postImageUrl = "https://res.cloudinary.com/dhbb2ehoi/image/upload/v1758967447/Screenshot_2025-09-27_at_14.59.15_iq66ym.png",
                caption = "The Secret History of Stonehenge (Short Form)\n" +
                        "Stonehenge, built about 4,600 years ago on Salisbury Plain in southern England, remains one of the world’s greatest mysteries. Legends once credited its origin to Merlin, Danes, or Romans, while modern myths link it to aliens or fertility rites.\n" +
                        "Archaeology shows it began as an earthwork 5,000 years ago, later transformed with bluestones from Wales and massive sarsen stones transported 19 miles. Some stones even trace back to Scotland, suggesting enormous effort—over 20 million hours of labor.\n" +
                        "Why it was built is still debated. Theories include:\n" +
                        "Astronomy/rituals: alignments with the sun, moon, and stars suggest use as a calendar or for seasonal ceremonies.\n" +
                        "Healing site: bluestones may have been believed to hold magical powers.\n" +
                        "Ancestor worship: linked with nearby Durrington Walls, symbolizing the realms of the living and the dead.\n" +
                        "Though its true purpose is uncertain, Stonehenge was clearly central to the spiritual and cultural life of prehistoric Britain.",
                likes = 178346,
                isLiked = false
            ),
            Post(
                    id = 2,
            username = "orange_cat",
            userAvatarUrl = "https://res.cloudinary.com/dhbb2ehoi/image/upload/v1758966630/b04c3d0169e52a7f7a9ad48c8a87701a_bfqv8x.avif",
            postImageUrl = "https://res.cloudinary.com/dhbb2ehoi/image/upload/v1758973193/Screenshot_2025-09-27_at_16.38.34_y64exy.png",
            caption = "Orcas Sink Another Boat off Portugal\n" +
                    "On September 13 near Lisbon, Portugal, three orcas rammed a sailboat so hard it sank. The crew was rescued unharmed.\n" +
                    "Experts believe the behavior—first noted in 2020 in the Strait of Gibraltar—is more playful than aggressive, though some suggest it started with a female orca, White Gladis, who may have been injured by a boat and passed the behavior on to others.\n" +
                    "Since then, hundreds of incidents have been reported off Spain and Portugal, with orcas often targeting boat rudders. Scientists describe it as a possible cultural “fad” among the Iberian orcas, a critically endangered group.\n" +
                    "Authorities urge sailors to avoid the animals and remember that, despite the name, wild killer whales have never attacked humans.",
            likes = 137486,
            isLiked = false
        ),
            Post(
                id = 3,
                username = "orange_cat",
                userAvatarUrl = "https://res.cloudinary.com/dhbb2ehoi/image/upload/v1758966630/b04c3d0169e52a7f7a9ad48c8a87701a_bfqv8x.avif",
                postImageUrl = "https://res.cloudinary.com/dhbb2ehoi/image/upload/v1758973779/Screenshot_2025-09-27_at_16.49.18_ly7z2j.png",
                caption = "Artemis II: NASA’s Next Step to the Moon\n" +
                        "Mission: Artemis II will send four astronauts (Reid Wiseman, Victor Glover, Christina Koch, Jeremy Hansen) on a 10-day trip around the moon, the first crewed lunar mission since 1972.\n" +
                        "Timeline: Official launch set for April 2026, possibly as early as February.\n" +
                        "Purpose: Test systems of the Orion capsule and SLS rocket, gather health data, and prepare for Artemis III’s lunar landing in 2027.\n" +
                        "Challenges: Heat shield issues from Artemis I were solved; batteries and valves replaced. A new “loft” re-entry path will ensure safety.\n" +
                        "Science Goals: Study astronaut health in deep space, test radiation effects (using tissue chips), and observe the far side of the moon—up to 60% of the view may be unique.\n" +
                        "Why it matters: Like Apollo 8, Artemis II sets the stage for a new era of lunar exploration aimed at building a long-term presence on the moon—and ultimately preparing for Mars.",
                likes = 137486,
                isLiked = false
            )
        )
    }
}