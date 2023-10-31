package uz.gita.contactwitworker.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.model.ContactData

interface DeleteContactFromApiUseCase {
    operator fun invoke(contactData: ContactData): Flow<Result<Boolean>>
}