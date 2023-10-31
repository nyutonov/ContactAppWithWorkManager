package uz.gita.contactwitworker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactwitworker.data.repository.AppRepositoryImpl
import uz.gita.contactwitworker.domain.repository.AppRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppRepositoryModule {
    @Binds
    fun repositoryBinder(impl: AppRepositoryImpl): AppRepository
}