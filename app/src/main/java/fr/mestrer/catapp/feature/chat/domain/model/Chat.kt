package fr.mestrer.catapp.feature.chat.domain.model

data class Chat(
    val id : String,
    val name: String = "Grizby",
    val imgCat: String,
    val width: Int,
    val height: Int
)
