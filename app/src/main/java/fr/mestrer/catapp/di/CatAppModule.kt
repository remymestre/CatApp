package fr.mestrer.catapp.di

import fr.mestrer.catapp.feature.chat.data.remote.ChatRequest
import fr.mestrer.catapp.feature.chat.data.remote.ChatRequestImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
            defaultRequest {
                url("https://api.thecatapi.com/v1/")
            }
        }
    }
}

val chatModule = module {
    single<ChatRequest> { ChatRequestImpl(get()) }
}