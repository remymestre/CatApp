package fr.mestrer.catapp.feature.chat.data.mapper

import android.R.attr.height
import fr.mestrer.catapp.feature.chat.data.remote.ChatRaw
import fr.mestrer.catapp.feature.chat.domain.model.Chat

fun ChatRaw.toChat(): Chat {
    return Chat(
        id = id,
        imgCat = url,
        width = width,
        height = height
    )
}