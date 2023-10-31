package uz.gita.contactwitworker.domain.model

import uz.gita.contactwitworker.data.source.local.entites.ContactEntity

data class ContactData (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    var isAddedToApi: Boolean
){
    fun toEntity(): ContactEntity = ContactEntity(
        id,
        firstName,
        lastName,
        phoneNumber,
        isAddedToApi
    )
}