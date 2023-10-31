package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.GetDeletedContactsUseCase
import javax.inject.Inject

class GetDeletedContactsUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : GetDeletedContactsUseCase {
    override fun invoke(): Flow<Result<List<ContactData>>> = appRepository.getDeletedContacts()
}