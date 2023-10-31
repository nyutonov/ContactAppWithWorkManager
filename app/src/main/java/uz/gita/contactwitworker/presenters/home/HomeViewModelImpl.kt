package uz.gita.contactwitworker.presenters.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.contactwitworker.data.model.ContactData
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val homeDirection: HomeDirectionImpl,
) : ViewModel(), HomeContract.HomeViewModel {
    override val uiState = MutableStateFlow(HomeContract.UIState())

    init {
        viewModelScope.launch {

        }
    }


    override fun onEventDispatcher(intent: HomeContract.Intent) {
        viewModelScope.launch {
            when (intent) {

                HomeContract.Intent.MoveToAdd -> {
                    homeDirection.moveToAdd()
                }

                is HomeContract.Intent.MoveToEdit -> {
                    homeDirection.moveToEdit(contactData = ContactData(0, "", "", "", false))
                }

            }


        }
    }
}