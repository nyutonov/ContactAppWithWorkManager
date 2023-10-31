package uz.gita.contactwitworker.presenters.add

import uz.gita.contactwitworker.presenters.home.HomeScreen
import uz.gita.contactwitworker.utils.navigation.AppNavigator

interface AddDirection {
    suspend fun back()
    suspend fun addAndBack()
}

class AddDirectionImpl(
    private val direction: AppNavigator,
) : AddDirection {
    override suspend fun back() {
        direction.back()
    }

    override suspend fun addAndBack() {
        direction.addScreen(HomeScreen())
    }

}