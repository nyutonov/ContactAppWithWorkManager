package uz.gita.contactwitworker.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData

interface AppRepository {
//    dao
    fun addContact(firstName: String, lastName: String, phoneNumber: String): Flow<Result<Boolean>>
    fun deleteContact(contactData: ContactData): Flow<Result<Boolean>>
    fun updateContact(id: Int, firstName: String, lastName: String, phoneNumber: String): Flow<Result<Boolean>>
//    dao ob beradi
    fun getNotUploadedContacts(): Flow<Result<List<ContactData>>>
    fun getDeletedContacts(): Flow<Result<List<ContactData>>>
    fun getUpdatedContacts(): Flow<Result<List<ContactData>>>
    fun getContactsFromDB(): Flow<Result<List<ContactData>>>
//    apiga yuklaydi
    fun addContactToApi(contactData: ContactData): Flow<Result<Boolean>>
    fun updateContactToApi(contactData: ContactData): Flow<Result<Boolean>>
    fun deleteContactFromApi(contactData: ContactData): Flow<Result<Boolean>>
    fun getContactsFromApi(): Flow<Result<List<ContactData>>>

}