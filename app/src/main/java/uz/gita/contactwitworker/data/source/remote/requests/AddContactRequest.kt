package uz.gita.contactwitworker.data.source.remote.requests
data class AddContactRequest (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
)