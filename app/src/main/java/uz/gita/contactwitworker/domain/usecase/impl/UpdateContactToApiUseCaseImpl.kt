package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.UpdateContactToApiUseCase
import javax.inject.Inject

class UpdateContactToApiUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : UpdateContactToApiUseCase {
    override fun invoke(contactData: ContactData): Flow<Result<Boolean>>  = appRepository.updateContactToApi(contactData)
}