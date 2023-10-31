package uz.gita.contactwitworker.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData

interface DeleteContactFromApiUseCase {
    operator fun invoke(contactData: ContactData): Flow<Result<Boolean>>
}