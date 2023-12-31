package uz.gita.contactwitworker.worker

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.contactwitworker.domain.usecase.AddContactToApiUseCase
import uz.gita.contactwitworker.domain.usecase.DeleteContactFromApiUseCase
import uz.gita.contactwitworker.domain.usecase.GetDeletedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.GetNotUploadedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.GetUpdatedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.UpdateContactToApiUseCase
import uz.gita.contactwitworker.notification.NotificationHelper

@HiltWorker
class mWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val getNotUploadedContactsUseCase: GetNotUploadedContactsUseCase,
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
        Log.d("TTT" , "work")
        getNotUploadedContactsUseCase.invoke()
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