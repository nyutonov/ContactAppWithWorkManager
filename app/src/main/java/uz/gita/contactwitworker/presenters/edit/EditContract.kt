package uz.gita.contactwitworker.presenters.edit

import kotlinx.coroutines.flow.StateFlow
import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest

interface EditContract {

    interface ViewModel{
        fun eventDispatcher(intent: Intent)
    }

    interface Direction{
        suspend fun backToMain()
    }

    interface Intent{
        object Cancel: Intent
        data class Edit(
            val id: Int,
            val firstName: String,
            val lastName: String,
            val phoneNumber: String
        ): Intent
    }
}