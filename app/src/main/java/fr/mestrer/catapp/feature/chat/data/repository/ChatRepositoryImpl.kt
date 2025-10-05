package fr.mestrer.catapp.feature.chat.data.repository

import android.util.Log
import fr.mestrer.catapp.feature.chat.data.mapper.toChat
import fr.mestrer.catapp.feature.chat.data.remote.ChatRequest
import fr.mestrer.catapp.feature.chat.domain.model.Chat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatRepositoryImpl(val chatRequest: ChatRequest): ChatRepository {
    override suspend fun getCats(): Flow<List<Chat>> {
        return chatRequest.getChats().map { rawList ->
            rawList.map { chatRaw ->
                Log.d("ChatRepositoryImpl", "getCats: $chatRaw")
                chatRaw.toChat()
            }
        }
    }
}