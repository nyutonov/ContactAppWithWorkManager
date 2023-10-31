package uz.gita.contactwitworker.presenters.add

import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest


interface AddContract {

    interface ViewModel{
        fun eventDispatcher(intent: Intent)
    }

    interface Direction{
        suspend fun backToMain()
    }

    interface Intent{
        object Cancel: Intent
        data class AddContact(
            val firstName: String,
            val lastName: String,
            val phoneNumber: String
        ): Intent
    }
}