package fr.mestrer.catapp.feature.chat.data.remote

import kotlinx.coroutines.flow.Flow

interface ChatRequest {
    fun getChats(): Flow<List<ChatRaw>>
}