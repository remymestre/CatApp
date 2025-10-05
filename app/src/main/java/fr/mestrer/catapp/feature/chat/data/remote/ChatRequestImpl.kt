package fr.mestrer.catapp.feature.chat.data.remote

import android.util.Log
import fr.mestrer.catapp.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.flow

class ChatRequestImpl(
    private val client: HttpClient
): ChatRequest {
    override fun getChats() = flow {
        Log.d("Request", "LAUNCHING CALL GET CHATS")

        val chats: List<ChatRaw> = client.get("images/search") {
            parameter("limit", 20)
            parameter("api_key", BuildConfig.CAT_API_KEY)
        }.body<List<ChatRaw>>()

        Log.d("Request", "Result GET CHATS: $chats")
        emit(chats)
    }
}