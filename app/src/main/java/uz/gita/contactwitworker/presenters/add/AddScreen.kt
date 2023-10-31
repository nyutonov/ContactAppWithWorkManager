package uz.gita.contactwitworker.presenters.add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest

class AddScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: AddContract.AddViewModel = getViewModel<AddViewModelImp>()

        AddScreenContent(
            viewModel::onEventDispatcher
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddScreenContent(
        onEventDispatcher: (AddContract.Intent) -> Unit = {},

        ) {

        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }

        Box(modifier = Modifier.fillMaxSize()) {


            Column(modifier = Modifier.fillMaxSize()) {

                TextField(value = firstName, onValueChange = {
                    firstName = it
                })
                TextField(value = lastName, onValueChange = {
                    lastName = it
                })
                TextField(value = phone, onValueChange = {
                    phone = it
                })

                Button(onClick = {
                    onEventDispatcher.invoke(
                        AddContract.Intent.AddContact(
                            AddContactRequest(
                                firstName,
                                lastName,
                                phone
                            )
                        )
                    )
                }) {
                    Text(text = "save")
                }
            }
        }
    }
}



