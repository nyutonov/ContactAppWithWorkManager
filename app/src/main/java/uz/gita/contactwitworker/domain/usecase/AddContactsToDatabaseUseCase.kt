package uz.gita.contactwitworker.domain.usecase

import kotlinx.coroutines.flow.Flow

interface AddContactsToDatabaseUseCase {
    operator fun invoke(firstName: String, lastName: String, phoneNumber: String): Flow<Result<Boolean>>
}