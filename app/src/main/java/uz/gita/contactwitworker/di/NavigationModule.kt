package uz.gita.contactwitworker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactwitworker.utils.navigation.AppNavigator
import uz.gita.contactwitworker.utils.navigation.AppNavigationDispatcher
import uz.gita.contactwitworker.utils.navigation.AppNavigationHandler
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface NavigationModule {
    @[Binds Singleton]
    fun bindNavigator(impl : AppNavigationDispatcher) : AppNavigator

    @[Binds Singleton]
    fun bindNavigationHandler(impl : AppNavigationDispatcher) : AppNavigationHandler
}