package uz.gita.contactwitworker.presenters.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.contactwitworker.domain.usecase.UpdateContactsToDatabaseUseCase
import javax.inject.Inject

@HiltViewModel
class EditViewModelImpl @Inject constructor(
    private val direction: EditContract.Direction,
    private val updateContactsToDatabaseUseCase: UpdateContactsToDatabaseUseCase,
) : ViewModel(), EditContract.ViewModel {
    override fun eventDispatcher(intent: EditContract.Intent) {
        when (intent) {
            EditContract.Intent.Cancel -> {
                viewModelScope.launch {
                    direction.backToMain()
                }
            }

            is EditContract.Intent.Edit -> {
                viewModelScope.launch { 
                    updateContactsToDatabaseUseCase(
                        intent.id,
                        intent.lastName,
                        intent.firstName,
                        intent.phoneNumber
                    ).onEach {
                        it.onSuccess { direction.backToMain() }
                            .onFailure { direction.backToMain() }
                    }.collect()
                }
            }
        }
    }
}