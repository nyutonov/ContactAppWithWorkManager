package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.GetUpdatedContactsUseCase
import javax.inject.Inject

class GetUpdatedContactsUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : GetUpdatedContactsUseCase {
    override fun invoke(): Flow<Result<List<ContactData>>> = appRepository.getUpdatedContacts()
}