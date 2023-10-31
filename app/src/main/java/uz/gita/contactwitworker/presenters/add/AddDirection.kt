package uz.gita.contactwitworker.presenters.add

import uz.gita.contactwitworker.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddDirection @Inject constructor(
    private val appNavigator: AppNavigator,
) : AddContract.Direction {
    override suspend fun backToMain() {
        appNavigator.back()
    }
}