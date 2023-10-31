package uz.gita.contactwitworker.presenters.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.contactwitworker.domain.usecase.AddContactsToDatabaseUseCase
import javax.inject.Inject


@HiltViewModel
class AddViewModelImp @Inject constructor(
    private val addContactsToDatabaseUseCase: AddContactsToDatabaseUseCase,
    private val direction: AddContract.Direction
) : ViewModel(), AddContract.ViewModel {
    override fun eventDispatcher(intent: AddContract.Intent) {
        when (intent) {
            is AddContract.Intent.AddContact -> {
                addContactsToDatabaseUseCase(
                    intent.firstName,
                    intent.lastName,
                    intent.phoneNumber
                )
                    .onEach {
                        it
                            .onSuccess { direction.backToMain() }
                            .onFailure { direction.backToMain() }
                    }
                    .launchIn(viewModelScope)
            }

            AddContract.Intent.Cancel -> {
                viewModelScope.launch {
                    direction.backToMain()
                }
            }
        }
    }
}