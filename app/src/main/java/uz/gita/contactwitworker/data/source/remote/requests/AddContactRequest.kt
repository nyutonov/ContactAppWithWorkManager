package uz.gita.contactwitworker.data.source.remote.requests
data class AddContactRequest (
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
)