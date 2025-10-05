package fr.mestrer.catapp.feature.chat.ui.list

import fr.mestrer.catapp.feature.chat.domain.model.Chat

sealed interface ChatListUiState {
    class Loading : ChatListUiState
    data class Success(val chats: List<Chat>) : ChatListUiState
    data class Error(val message: String) : ChatListUiState
}