package uz.gita.contactwitworker.presenters.home

import kotlinx.coroutines.flow.StateFlow
import uz.gita.contactwitworker.domain.model.ContactData

interface HomeContract {

    interface ViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }


    data class UIState(
        val list: List<ContactData> = listOf(),
    )

    interface Direction {
        suspend fun moveToAdd()
        suspend fun moveToEdit(contactData: ContactData)
    }



    interface Intent {
        object MoveToAdd : Intent
        data class MoveToEdit(val contactData: ContactData) : Intent
        data class Delete(val contactData: ContactData) : Intent
    }
}