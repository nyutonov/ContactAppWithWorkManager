package uz.gita.contactwitworker.presenters.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.contactwitworker.ui.components.ItemContact

class HomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: HomeContract.ViewModel  = getViewModel<HomeViewModelImpl>()

        HomeScreenContent(uiState = viewModel.uiState.collectAsState(), onEventDispatcher = viewModel::onEventDispatcher)
    }

    @Composable
    fun HomeScreenContent(
        uiState: State<HomeContract.UIState>,
        onEventDispatcher:(HomeContract.Intent) -> Unit
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn() {
                items(uiState.value.list){
                    ItemContact(
                        contactData = it,
                        { onEventDispatcher.invoke(HomeContract.Intent.MoveToEdit(it)) },
                        { onEventDispatcher.invoke(HomeContract.Intent.Delete(it)) }
                    )
                }
            }

            FloatingActionButton(onClick = { onEventDispatcher.invoke(HomeContract.Intent.MoveToAdd) }, modifier = Modifier.align(
                Alignment.BottomEnd).padding(12.dp)) {
                Text(text = "+")
            }
        }
    }
}