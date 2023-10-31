package uz.gita.contactwitworker.worker

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.contactwitworker.domain.usecase.AddContactToApiUseCase
import uz.gita.contactwitworker.domain.usecase.DeleteContactFromApiUseCase
import uz.gita.contactwitworker.domain.usecase.GetContactsFromDBUseCase
import uz.gita.contactwitworker.domain.usecase.GetDeletedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.GetUpdatedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.UpdateContactToApiUseCase
import uz.gita.contactwitworker.notification.NotificationHelper
import javax.inject.Inject

class Worker @Inject constructor(
    context: Context,
    params: WorkerParameters,
    private val getContactsFromDBUseCase: GetContactsFromDBUseCase,
    private val getUpdatedContactsUseCase: GetUpdatedContactsUseCase,
    private val getDeletedContactsUseCase: GetDeletedContactsUseCase,
    private val addContactToApi: AddContactToApiUseCase,
    private val updateContactToApi: UpdateContactToApiUseCase,
    private val deleteContactToApi: DeleteContactFromApiUseCase,
) : Worker(context, params) {
    private val notificationHelper by lazy { NotificationHelper(context) }

    private val scope1 = CoroutineScope(Dispatchers.IO)
    private val scope2 = CoroutineScope(Dispatchers.IO)

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        getContactsFromDBUseCase.invoke()
            .onEach {
                it.onSuccess {
                    it.forEach {
                        addContactToApi.invoke(it)
                            .onEach {  }
                            .launchIn(scope2)
                    }
                }

                it.onFailure {
                    //...
                }
            }
            .launchIn(scope1)

        getUpdatedContactsUseCase.invoke()
            .onEach {
                it.onSuccess {
                    it.forEach {
                        updateContactToApi.invoke(it)
                            .onEach {  }
                            .launchIn(scope2)
                    }
                }

                it.onFailure {
                    //...
                }
            }
            .launchIn(scope1)

        getDeletedContactsUseCase.invoke()
            .onEach {
                it.onSuccess {
                    it.forEach {
                        deleteContactToApi.invoke(it)
                            .onEach {  }
                            .launchIn(scope2)
                    }
                }

                it.onFailure {
                    //...
                }
            }
            .launchIn(scope1)

        notificationHelper.notificationManagerCompat.notify(1, notificationHelper.getNotification())

        return Result.success()
    }
}