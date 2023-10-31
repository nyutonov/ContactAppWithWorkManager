package uz.gita.contactwitworker.data.source.remote.response

import uz.gita.contactwitworker.domain.model.ContactData

data class ContactResponseItem(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String
){
    fun toData(): ContactData = ContactData(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phone,
        isAddedToApi = true
    )
}