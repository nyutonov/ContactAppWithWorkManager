package uz.gita.contactwitworker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactwitworker.presenters.add.AddContract
import uz.gita.contactwitworker.presenters.add.AddDirection
import uz.gita.contactwitworker.presenters.edit.EditContract
import uz.gita.contactwitworker.presenters.edit.EditDirection
import uz.gita.contactwitworker.presenters.home.HomeContract
import uz.gita.contactwitworker.presenters.home.HomeDirection

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {

    @Binds
    fun addDirectionBinder(impl: AddDirection): AddContract.Direction

    @Binds
    fun editDirectionBinder(impl: EditDirection): EditContract.Direction

    @Binds
    fun homeDirectionBinder(impl: HomeDirection): HomeContract.Direction
}