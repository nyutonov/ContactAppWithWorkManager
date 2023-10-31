package uz.gita.contactwitworker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactwitworker.domain.usecase.AddContactToApiUseCase
import uz.gita.contactwitworker.domain.usecase.AddContactsToDatabaseUseCase
import uz.gita.contactwitworker.domain.usecase.DeleteContactFromApiUseCase
import uz.gita.contactwitworker.domain.usecase.DeleteContactsToDatabaseUseCase
import uz.gita.contactwitworker.domain.usecase.GetContactsFromApiUseCse
import uz.gita.contactwitworker.domain.usecase.GetContactsFromDBUseCase
import uz.gita.contactwitworker.domain.usecase.GetDeletedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.GetNotUploadedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.GetUpdatedContactsUseCase
import uz.gita.contactwitworker.domain.usecase.UpdateContactToApiUseCase
import uz.gita.contactwitworker.domain.usecase.UpdateContactsToDatabaseUseCase
import uz.gita.contactwitworker.domain.usecase.impl.AddContactToApiUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.AddContactsToDatabaseUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.DeleteContactFromApiUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.DeleteContactsToDatabaseUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.GetContactsFromApiUseCseImpl
import uz.gita.contactwitworker.domain.usecase.impl.GetContactsFromDBUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.GetDeletedContactsUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.GetNotUploadedContactsUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.GetUpdatedContactsUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.UpdateContactToApiUseCaseImpl
import uz.gita.contactwitworker.domain.usecase.impl.UpdateContactsToDatabaseUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @[Binds Singleton]
    fun bindAddContactsToDatabaseUseCase(impl: AddContactsToDatabaseUseCase): AddContactsToDatabaseUseCaseImpl

    @[Binds Singleton]
    fun bindDeleteContactFromApiUseCase(impl: DeleteContactFromApiUseCase): DeleteContactFromApiUseCaseImpl

    @[Binds Singleton]
    fun bindAddContactToApiUseCase(impl: AddContactToApiUseCase): AddContactToApiUseCaseImpl

    @[Binds Singleton]
    fun bindDeleteContactsToDatabaseUseCase(impl: DeleteContactsToDatabaseUseCase): DeleteContactsToDatabaseUseCaseImpl

    @[Binds Singleton]
    fun bindGetContactsFromApiUseCse(impl: GetContactsFromApiUseCse): GetContactsFromApiUseCseImpl

    @[Binds Singleton]
    fun bindGetContactsFromDBUseCase(impl: GetContactsFromDBUseCase): GetContactsFromDBUseCaseImpl

    @[Binds Singleton]
    fun bindUpdateToApiContactUseCase(impl: GetDeletedContactsUseCase): GetDeletedContactsUseCaseImpl

    @[Binds Singleton]
    fun bindGetNotUploadedContactsUseCase(impl: GetNotUploadedContactsUseCase): GetNotUploadedContactsUseCaseImpl

    @[Binds Singleton]
    fun bindGetUpdatedContactsUseCase(impl: GetUpdatedContactsUseCase): GetUpdatedContactsUseCaseImpl

    @[Binds Singleton]
    fun bindUpdateContactsToDatabaseUseCase(impl: UpdateContactsToDatabaseUseCase): UpdateContactsToDatabaseUseCaseImpl

    @[Binds Singleton]
    fun bindUpdateToApiContactUseCase(impl: UpdateContactToApiUseCase): UpdateContactToApiUseCaseImpl
}