package uz.gita.contactwitworker.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.model.ContactData

interface AddContactToApiUseCase {
    operator fun invoke(contactData: ContactData): Flow<Result<Boolean>>
}