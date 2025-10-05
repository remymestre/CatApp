package fr.mestrer.catapp.feature.chat.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.mestrer.catapp.feature.chat.data.repository.ChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ChatListViewModel(val chatRepository: ChatRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<ChatListUiState> = MutableStateFlow(ChatListUiState.Loading())
    val uiState: StateFlow<ChatListUiState> = _uiState

    init {
        println("Init ChatListViewModel")
        getChats()
    }

    fun getChats() {
        viewModelScope.launch {
            chatRepository.getCats()
                .catch { e ->
                    Log.e("ChatListViewModel", "getChats: $e")
                    _uiState.value = ChatListUiState.Error(e.message ?: "Erreur inconnue")
                }
                .collect {
                    chats ->
                    println("<<<<< chats$chats")
                    _uiState.value = ChatListUiState.Success(chats)
                }
        }
    }
}