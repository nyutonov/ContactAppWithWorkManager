package uz.gita.contactwitworker.presenters.edit

import uz.gita.contactwitworker.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EditDirection @Inject constructor(
    private val appNavigator: AppNavigator,
) : EditContract.Direction {
    override suspend fun backToMain() {
        appNavigator.back()
    }
}