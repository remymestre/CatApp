package fr.mestrer.catapp.feature.chat.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ChatRaw(
    val id: String,
    val title: String,
    val width: Int,
    val weight: Int,
    val url: String,
    val breeds: List<String>,
    val categories: List<ChatCategoryRaw>
)

data class ChatCategoryRaw(
    val id: Int,
    val name: String
)
