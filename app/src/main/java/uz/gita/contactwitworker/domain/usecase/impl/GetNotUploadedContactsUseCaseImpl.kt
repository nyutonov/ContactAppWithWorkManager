package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.GetNotUploadedContactsUseCase
import javax.inject.Inject

class GetNotUploadedContactsUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : GetNotUploadedContactsUseCase {
    override fun invoke(): Flow<Result<List<ContactData>>> = appRepository.getNotUploadedContacts()
}