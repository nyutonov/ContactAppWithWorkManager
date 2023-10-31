package uz.gita.contactwitworker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.contactwitworker.data.source.local.shared.Shared
import uz.gita.contactwitworker.presenters.home.HomeScreen
import uz.gita.contactwitworker.ui.theme.ContactWitWorkerTheme
import uz.gita.contactwitworker.utils.navigation.AppNavigationHandler
import uz.gita.contactwitworker.worker.mWorker
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appNavigationHandler: AppNavigationHandler

    @Inject
    lateinit var shared: Shared
    @SuppressLint("CoroutineCreationDuringComposition", "FlowOperatorInvokedInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (shared.isFirstTime()) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val workRequest = PeriodicWorkRequestBuilder<mWorker>(15L, TimeUnit.MINUTES, 5L, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(this).enqueue(workRequest)

            shared.openFirstTime()
        }

/*        val workRequest = OneTimeWorkRequestBuilder<mWorker>().setInitialDelay(2L, TimeUnit.SECONDS).build()
        WorkManager.getInstance(this).enqueue(workRequest)*/
        setContent {
            ContactWitWorkerTheme {
                ContactWitWorkerTheme {
                    Navigator(screen = HomeScreen()) { navigator ->
                        appNavigationHandler.uiNavigator.onEach {
                            it.invoke(navigator)
                        }.launchIn(lifecycleScope)
                        CurrentScreen()
                    }
                }
            }
        }
    }
}
