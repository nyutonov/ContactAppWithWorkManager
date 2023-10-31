package uz.gita.contactwitworker.presenters.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModelImpl @Inject constructor(
    private val direction: EditDirectionImpl,
) : ViewModel(), EditContract.EditViewModel {
    override val uiState = MutableStateFlow(EditContract.UIState())


    override fun onEventDispatcher(intent: EditContract.Intent) {
        when (intent) {
            is EditContract.Intent.SaveAndBack -> {
                viewModelScope.launch {
                    direction.saveAndBack(contactData = intent.contactData)
                }
            }
        }
    }
}