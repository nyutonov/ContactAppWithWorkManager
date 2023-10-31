package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.AddContactsToDatabaseUseCase
import javax.inject.Inject

class AddContactsToDatabaseUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : AddContactsToDatabaseUseCase {
    override fun invoke(
        firstName: String,
        lastName: String,
        phoneNumber: String,
    ): Flow<Result<Boolean>> = appRepository
        .addContact(
            0,
            firstName,
            lastName,
            phoneNumber
        )
}