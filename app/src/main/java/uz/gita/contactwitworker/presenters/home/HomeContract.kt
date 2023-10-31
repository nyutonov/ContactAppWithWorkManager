package uz.gita.contactwitworker.presenters.home

import kotlinx.coroutines.flow.StateFlow
import uz.gita.contactwitworker.data.model.ContactData

interface HomeContract {

    interface HomeViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }


    data class UIState(
        val list: List<ContactData> = emptyList(),
    )


    interface Intent {
        object MoveToAdd : Intent
        data class MoveToEdit(val contactData: ContactData) : Intent
    }
}