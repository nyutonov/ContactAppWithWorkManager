package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.UpdateContactsToDatabaseUseCase
import javax.inject.Inject

class UpdateContactsToDatabaseUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : UpdateContactsToDatabaseUseCase {
    override fun invoke(
        id: Int,
        firstName: String,
        lastName: String,
        phoneNumber: String,
    ): Flow<Result<Boolean>>  = appRepository
        .updateContact(
            id = id,
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber
        )
}