package uz.gita.contactwitworker.presenters.home

import uz.gita.contactwitworker.presenters.edit.EditScreen
import uz.gita.contactwitworker.domain.model.ContactData
import uz.gita.contactwitworker.presenters.add.AddScreen
import uz.gita.contactwitworker.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeDirection @Inject constructor (
    private val appNavigator: AppNavigator
) : HomeContract.Direction {
    override suspend fun moveToAdd() {
        appNavigator.addScreen(AddScreen())
    }

    override suspend fun moveToEdit(contactData: ContactData) {
        appNavigator.addScreen(EditScreen(contactData))
    }
}