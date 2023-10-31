package uz.gita.contactwitworker.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.model.ContactData

interface GetContactsFromDBUseCase {
    operator fun invoke(): Flow<Result<List<ContactData>>>
}