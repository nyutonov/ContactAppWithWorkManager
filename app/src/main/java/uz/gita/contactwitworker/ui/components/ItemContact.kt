package uz.gita.contactwitworker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.gita.contactwitworker.R
import uz.gita.contactwitworker.domain.model.ContactData

@Composable
fun ItemContact(
    contactData: ContactData,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Column(modifier = Modifier.height(56.dp)) {
                Text(text = contactData.firstName)
                Text(text = contactData.lastName)
                Text(text = contactData.phoneNumber)
            }

            Spacer(modifier = Modifier.size(100.dp))

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.delete), contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}