package fr.mestrer.catapp.feature.chat.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.mestrer.catapp.feature.chat.domain.model.Chat

@Composable
fun ChatListScreen(viewModel: ChatListViewModel, modifier: Modifier = Modifier) {
    val uiState = viewModel.uiState.collectAsState()
    ChatMainScreen(uiState.value, { viewModel.getChats() }, modifier)
}

@Composable
fun ChatMainScreen(uiState: ChatListUiState, getChats: () -> Unit, modifier: Modifier = Modifier) {
    when (uiState) {
        is ChatListUiState.Error -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
                Button(onClick = { getChats() }) {
                    Text(text = "Refresh")
                }
                Text(text = uiState.message)
            }
        }
        is ChatListUiState.Loading -> Text(text = "Loading", modifier)
        is ChatListUiState.Success -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
                Text(text = "${uiState.chats}")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ChatPreview() {
    ChatMainScreen(
        ChatListUiState.Success(
            listOf(
                Chat(
                    "id",
                    "url",
                    "",
                    100,
                    height = 100
                )
            )
        ),
        {}
    )
}