package fr.mestrer.catapp.feature.chat.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ChatRaw(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)

@Serializable
data class ChatCategoryRaw(
    val id: Int,
    val name: String
)

@Serializable
data class BreedRaw(
    val id: String,
    val name: String,
)