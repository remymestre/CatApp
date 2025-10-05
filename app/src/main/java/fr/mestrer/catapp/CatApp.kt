package fr.mestrer.catapp

import android.app.Application
import fr.mestrer.catapp.di.chatModule
import fr.mestrer.catapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CatApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CatApp)
            modules(
                networkModule,
                chatModule
            )
        }
    }
}