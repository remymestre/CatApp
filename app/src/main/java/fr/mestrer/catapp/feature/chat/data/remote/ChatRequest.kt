package fr.mestrer.catapp.feature.chat.data.remote

interface ChatRequest {
    suspend fun getChats(): List<ChatRaw>
}