package uz.gita.contactwitworker.data.source.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.contactwitworker.domain.model.ContactData

@Entity("contact")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    var isAddedToApi: Boolean = true,
    var isUpdated: Boolean = false,
    var isDeleted: Boolean = false
){
    fun toData(): ContactData = ContactData(
        id, firstName, lastName, phoneNumber, isAddedToApi
    )
}
