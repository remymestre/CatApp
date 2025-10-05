package fr.mestrer.catapp.feature.chat.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ChatRequestImpl(
    private val client: HttpClient
): ChatRequest {
    override suspend fun getChats(): List<ChatRaw> {
        return client.get("images/search?limit=20&api_key=live_uSMvdkxjcizoj8AyAsFHARbmaSEapVU4FKe49QcOrOL6KkkA7GGm9oYky5F4Y3fQ") {
            parameter("limit", 20)
            parameter("api_key", BuildConfig.CAT_API_KEY)
        }.body()
    }
}