package uz.gita.contactwitworker.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.data.source.local.dao.AppDao
import uz.gita.contactwitworker.data.source.local.entites.ContactEntity
import uz.gita.contactwitworker.data.source.local.shared.Shared
import uz.gita.contactwitworker.data.source.remote.AppApi
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest
import uz.gita.contactwitworker.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val dao: AppDao,
    private val shared: Shared,
    private val api: AppApi,
) : AppRepository {
    override fun addContact(
        id: Int,
        firstName: String,
        lastName: String,
        phoneNumber: String,
    ): Flow<Result<Boolean>> = flow{
        dao.insertContacts(
            ContactEntity(
                id = 0,
                firstName = firstName,
                lastName = lastName,
                phoneNumber = phoneNumber,
                isAddedToApi = false,
                isUpdated = false,
                isDeleted = false,
            )
        )

        emit(Result.success(true))

    }.catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun deleteContact(contactData: ContactData): Flow<Result<Boolean>> = flow{
        dao.updateContacts(contactData.toEntity().copy(isDeleted = true))
        emit(Result.success(true))

    }.catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun updateContact(
        id: Int,
        firstName: String,
        lastName: String,
        phoneNumber: String,
    ): Flow<Result<Boolean>> = flow<Result<Boolean>> {
        dao.updateContacts(
            ContactEntity(
                id,
                firstName,
                lastName,
                phoneNumber,
                isAddedToApi = false,
                isDeleted = false,
                isUpdated = false
            )
        )

        emit(Result.success(true))
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun getNotUploadedContacts(): Flow<Result<List<ContactData>>> = flow{
        dao.getNotUploadedContacts().onEach {
            emit(Result.success(
                it.map { it.toData() }
            ))
        }.collect()
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun getDeletedContacts(): Flow<Result<List<ContactData>>> = flow {
        dao.getDeletedContacts().onEach {
            emit(
                Result.success(
                    it.map {
                        it.toData()
                    }
                )
            )
        }.collect()

    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun getUpdatedContacts(): Flow<Result<List<ContactData>>> = flow {
        dao.getUpdatedContacts().onEach {
            emit(
                Result.success(
                    it.map {
                        it.toData()
                    }
                )
            )
        }.collect()

    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun getContactsFromDB(): Flow<Result<List<ContactData>>> = flow {
        dao.getAllContacts().onEach {
            emit(
                Result.success(
                    it.map { it.toData() }
                )
            )
        }.collect()
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun addContactToApi(contactData: ContactData): Flow<Result<Boolean>> = flow{
        val response = api.addContact(
            AddContactRequest(
                firstName = contactData.firstName,
                lastName = contactData.firstName,
                phoneNumber = contactData.phoneNumber
            )
        )

        if (response.isSuccessful && response.body() != null) {
            emit(Result.success(true))
        }else emit(Result.success(false))

    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun updateContactToApi(contactData: ContactData): Flow<Result<Boolean>> = flow{
        val response = api.updateContact(
            AddContactRequest(
                firstName = contactData.firstName,
                lastName = contactData.firstName,
                phoneNumber = contactData.phoneNumber
            )
        )

        if (response.isSuccessful && response.body() != null) {
            emit(Result.success(true))
        }else emit(Result.success(false))
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun deleteContactFromApi(contactData: ContactData): Flow<Result<Boolean>> = flow{
        val response = api.deleteContact(
            contactData.id
        )

        if (response.isSuccessful && response.body() != null) {
            emit(Result.success(true))
        }else emit(Result.success(false))
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun getContactsFromApi(): Flow<Result<List<ContactData>>> = flow {
        val response = api.getContacts()

        if (response.isSuccessful && response.body() != null) {
            response.body().let {
                it?.forEach{
                    dao.insertContacts(it.toData().toEntity())
                }
                emit(
                    Result.success(
                        it?.map { it.toData() } ?: listOf()
                    )
                )

            }
        }else emit(Result.failure(Exception("Occurs something unknown")))

    }.catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)
}