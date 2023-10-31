package uz.gita.contactwitworker.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData

interface GetDeletedContactsUseCase {
    operator fun invoke(): Flow<Result<List<ContactData>>>
}