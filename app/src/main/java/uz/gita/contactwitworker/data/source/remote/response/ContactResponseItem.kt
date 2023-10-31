package uz.gita.contactwitworker.data.source.remote.response

import uz.gita.contactwitworker.data.model.ContactData

data class ContactResponseItem(
    val firstName: String,
    val id: Int,
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