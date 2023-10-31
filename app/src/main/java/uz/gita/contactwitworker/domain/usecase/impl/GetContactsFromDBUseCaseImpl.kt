package uz.gita.contactwitworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.domain.repository.AppRepository
import uz.gita.contactwitworker.domain.usecase.GetContactsFromDBUseCase
import javax.inject.Inject

class GetContactsFromDBUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository,
) : GetContactsFromDBUseCase {
    override fun invoke(): Flow<Result<List<ContactData>>> = appRepository.getContactsFromDB()
}