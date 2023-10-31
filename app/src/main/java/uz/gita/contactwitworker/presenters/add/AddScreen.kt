package uz.gita.contactwitworker.presenters.add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest

class AddScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: AddContract.ViewModel = getViewModel<AddViewModelImp>()

        AddScreenContent(
            viewModel::eventDispatcher
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


            Column(modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)) {
                TextField(
                    value = firstName,
                    onValueChange = {
                        firstName = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(Color.White),
                    label = { Text(text = "Firstname")}
                )

                Spacer(modifier = Modifier.size(12.dp))

                TextField(value = lastName, onValueChange = {
                    lastName = it
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(Color.White),
                    label = { Text(text = "Lastname")}
                )

                Spacer(modifier = Modifier.size(12.dp))

                TextField(
                    value = phone, onValueChange = {
                        phone = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(Color.White),
                    label = { Text(text = "Phone")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )

            }

            Row(Modifier.align(Alignment.BottomCenter)) {
                Spacer(modifier = Modifier.size(12.dp))
                Button(onClick = {
                    onEventDispatcher.invoke(
                        AddContract.Intent
                            .AddContact(
                                firstName = firstName,
                                lastName = lastName,
                                phoneNumber = phone
                            )
                    )
                }, modifier = Modifier.weight(1f)) {
                    Text(text = "save")
                }

                Spacer(modifier = Modifier.size(12.dp))

                Button(onClick = {
                    onEventDispatcher.invoke(
                        AddContract.Intent.Cancel
                    )
                }) {
                    Text(text = "Cancel")
                }

                Spacer(modifier = Modifier.size(12.dp))
            }
        }
    }
}



