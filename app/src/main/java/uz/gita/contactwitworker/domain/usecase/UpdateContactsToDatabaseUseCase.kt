package uz.gita.contactwitworker.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UpdateContactsToDatabaseUseCase {
    operator fun invoke(id: Int, firstName: String, lastName: String, phoneNumber: String): Flow<Result<Boolean>>
}