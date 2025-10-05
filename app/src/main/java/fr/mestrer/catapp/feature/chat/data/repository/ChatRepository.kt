package fr.mestrer.catapp.feature.chat.data.repository

import fr.mestrer.catapp.feature.chat.data.mapper.toChat
import fr.mestrer.catapp.feature.chat.data.remote.ChatRequest
import fr.mestrer.catapp.feature.chat.domain.model.Chat
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    suspend fun getCats(): Flow<List<Chat>>
}