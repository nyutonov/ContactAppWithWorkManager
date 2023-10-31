package uz.gita.contactwitworker.presenters.add

import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest


interface AddContract {

    interface AddViewModel {
        fun onEventDispatcher(intent: Intent)

    }


    interface Intent {
        data class AddContact(val contactData: AddContactRequest): Intent
    }
}