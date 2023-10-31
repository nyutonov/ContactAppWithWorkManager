package uz.gita.contactwitworker.presenters.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.ui.components.ItemContact

class HomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {

    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenContentPrev() {
    HomeScreenContent()
}


@Composable
fun HomeScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            items(100) {
                ItemContact(contactData = ContactData(0, "", "", "", false))
            }
        }
    }
}