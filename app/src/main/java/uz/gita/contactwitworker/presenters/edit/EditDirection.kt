package uz.gita.contactwitworker.presenters.edit

import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.presenters.home.HomeScreen
import uz.gita.contactwitworker.utils.navigation.AppNavigator

interface EditDirection {
    suspend fun saveAndBack(contactData: ContactData)
}

class EditDirectionImpl(
    private val direction: AppNavigator,
) : EditDirection {
    override suspend fun saveAndBack(contactData: ContactData) {
        direction.addScreen(HomeScreen())
    }
}