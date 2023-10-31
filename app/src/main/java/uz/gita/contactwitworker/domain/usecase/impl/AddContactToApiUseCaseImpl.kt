package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.AddContactToApiUseCase
import javax.inject.Inject

class AddContactToApiUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : AddContactToApiUseCase {
    override fun invoke(contactData: ContactData): Flow<Result<Boolean>> = appRepository.addContactToApi(contactData)
}