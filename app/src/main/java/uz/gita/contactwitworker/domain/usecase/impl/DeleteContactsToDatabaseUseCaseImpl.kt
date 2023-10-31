package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.DeleteContactsToDatabaseUseCase
import javax.inject.Inject

class DeleteContactsToDatabaseUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : DeleteContactsToDatabaseUseCase {
    override fun invoke(contactData: ContactData): Flow<Result<Boolean>> = appRepository.deleteContact(contactData)
}