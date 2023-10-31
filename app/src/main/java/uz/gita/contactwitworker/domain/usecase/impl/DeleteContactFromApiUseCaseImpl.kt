package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.DeleteContactFromApiUseCase
import javax.inject.Inject

class DeleteContactFromApiUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : DeleteContactFromApiUseCase {
    override fun invoke(contactData: ContactData): Flow<Result<Boolean>>  = appRepository.deleteContactFromApi(contactData)
}