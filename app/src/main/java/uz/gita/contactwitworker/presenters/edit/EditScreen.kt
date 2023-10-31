package uz.gita.contactwitworker.presenters.edit

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest

class EditScreen(private val contactData: ContactData) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: EditContract.EditViewModel = getViewModel<EditViewModelImpl>()

        EditScreenContent(
            uiState = viewModel.uiState.collectAsState(),
            viewModel::onEventDispatcher,
            contactData
        )
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun EditScreenContentPrev() {
//    EditScreenContent(mutableStateOf(EditContract.UIState()))
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenContent(
    uiState: State<EditContract.UIState>,
    onEventDispatcher: (EditContract.Intent) -> Unit,
    contactData: ContactData
) {

    var firstName by remember { mutableStateOf(contactData.firstName) }
    var lastName by remember { mutableStateOf(contactData.lastName) }
    var phone by remember { mutableStateOf(contactData.phoneNumber) }

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
                    EditContract.Intent.SaveAndBack(
                        ContactData(
                            contactData.id,
                            firstName,
                            lastName,
                            phone,
                            false
                        )
                    )
                )
            }) {
                Text(text = "edit")
            }
        }
    }
}