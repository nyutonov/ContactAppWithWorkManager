package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.GetContactsFromApiUseCse
import javax.inject.Inject

class GetContactsFromApiUseCseImpl @Inject constructor(
    private val appRepository: AppRepository,
): GetContactsFromApiUseCse {
    override fun invoke(): Flow<Result<List<ContactData>>> = appRepository.getContactsFromApi()
}