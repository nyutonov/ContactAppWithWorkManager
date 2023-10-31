package uz.gita.contactwitworker.presenters.edit

import kotlinx.coroutines.flow.StateFlow
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest

interface EditContract {

    interface EditViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }

    data class UIState(
        val data: ContactData? = null,
    )

    interface Intent {

        data class SaveAndBack(val contactData: ContactData) : Intent
    }
}