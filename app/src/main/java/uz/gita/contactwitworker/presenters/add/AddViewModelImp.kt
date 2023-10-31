package uz.gita.contactwitworker.presenters.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.contactwitworker.domain.usecase.AddContactsToDatabaseUseCase
import javax.inject.Inject


@HiltViewModel
class AddViewModelImp @Inject constructor(
    private val addContactsToDatabaseUseCase: AddContactsToDatabaseUseCase
) : ViewModel(), AddContract.AddViewModel {
    override fun onEventDispatcher(intent: AddContract.Intent) {
        viewModelScope.launch {
            when (intent) {
                is AddContract.Intent.AddContact -> {
                    addContactsToDatabaseUseCase.invoke(
                        intent.contactData.firstName,
                        intent.contactData.lastName,
                        intent.contactData.phoneNumber
                    )
                }
            }
        }
    }
}