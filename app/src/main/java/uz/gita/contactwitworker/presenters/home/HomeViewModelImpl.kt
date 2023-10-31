package uz.gita.contactwitworker.presenters.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.gita.contactwitworker.domain.usecase.AddContactToApiUseCase
import uz.gita.contactwitworker.domain.usecase.DeleteContactFromApiUseCase
import uz.gita.contactwitworker.domain.usecase.DeleteContactsToDatabaseUseCase
import uz.gita.contactwitworker.domain.usecase.GetContactsFromApiUseCse
import uz.gita.contactwitworker.domain.usecase.GetContactsFromDBUseCase
import uz.gita.contactwitworker.domain.usecase.GetUpdatedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.UpdateContactToApiUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val direction: HomeContract.Direction,
    private val deleteContactsToDatabaseUseCase: DeleteContactsToDatabaseUseCase,
    private val getContactsFromApiUseCse: GetContactsFromApiUseCse,
    private val getContactsFromDBUseCase: GetContactsFromDBUseCase
) : ViewModel(),HomeContract.ViewModel {
    override val uiState = MutableStateFlow(HomeContract.UIState())
    override fun onEventDispatcher(intent: HomeContract.Intent) {
        when (intent) {
            HomeContract.Intent.MoveToAdd -> {
                viewModelScope.launch { direction.moveToAdd() }
            }

            is HomeContract.Intent.MoveToEdit -> {
                viewModelScope.launch {
                    direction.moveToEdit(intent.contactData)
                }
            }

            is HomeContract.Intent.Delete -> {
                deleteContactsToDatabaseUseCase.invoke(intent.contactData).onEach {
                    it.onSuccess {  }
                }.launchIn(viewModelScope)
            }
        }
    }


    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getContactsFromApiUseCse.invoke().onEach {
//                    it
//                        .onSuccess {
//                            uiState.update { uiState -> uiState.copy(list = it) }
//                        }
                }
                    .launchIn(viewModelScope)

                getContactsFromDBUseCase.invoke().onEach {
                    it
                        .onSuccess {
                            uiState.update { uiState -> uiState.copy(list = it) }
                        }
                }.collect()
            }
        }
    }


}