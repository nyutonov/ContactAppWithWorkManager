package uz.gita.contactwitworker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uz.gita.contactwitworker.ui.theme.ContactWitWorkerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactWitWorkerTheme {

            }
        }
    }
}
