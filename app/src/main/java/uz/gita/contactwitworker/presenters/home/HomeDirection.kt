package uz.gita.contactwitworker.presenters.home

import uz.gita.contactwitworker.data.model.ContactData
import uz.gita.contactwitworker.presenters.add.AddScreen
import uz.gita.contactwitworker.presenters.edit.EditScreen
import uz.gita.contactwitworker.utils.navigation.AppNavigator

interface HomeDirection {
    suspend fun moveToAdd()
    suspend fun moveToEdit(contactData: ContactData)
}

class HomeDirectionImpl(
    private val direction: AppNavigator,
) : HomeDirection {

    override suspend fun moveToAdd() {
        direction.addScreen(AddScreen())
    }

    override suspend fun moveToEdit(contactData: ContactData) {
        direction.addScreen(EditScreen(contactData))
    }

}