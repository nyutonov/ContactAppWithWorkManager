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

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @[Binds]
    fun bindAddContactsToDatabaseUseCase(impl: AddContactsToDatabaseUseCaseImpl): AddContactsToDatabaseUseCase

    @[Binds]
    fun bindDeleteContactFromApiUseCase(impl: DeleteContactFromApiUseCaseImpl): DeleteContactFromApiUseCase

    @[Binds]
    fun bindAddContactToApiUseCase(impl: AddContactToApiUseCaseImpl): AddContactToApiUseCase

    @[Binds]
    fun bindDeleteContactsToDatabaseUseCase(impl: DeleteContactsToDatabaseUseCaseImpl): DeleteContactsToDatabaseUseCase

    @[Binds]
    fun bindGetContactsFromApiUseCse(impl: GetContactsFromApiUseCseImpl): GetContactsFromApiUseCse

    @[Binds]
    fun bindGetContactsFromDBUseCase(impl: GetContactsFromDBUseCaseImpl): GetContactsFromDBUseCase

    @[Binds]
    fun bindGetDeletedContactUseCase(impl: GetDeletedContactsUseCaseImpl): GetDeletedContactsUseCase

    @[Binds]
    fun bindGetNotUploadedContactsUseCase(impl: GetNotUploadedContactsUseCaseImpl): GetNotUploadedContactsUseCase

    @[Binds]
    fun bindGetUpdatedContactsUseCase(impl: GetUpdatedContactsUseCaseImpl): GetUpdatedContactsUseCase

    @[Binds]
    fun bindUpdateContactsToDatabaseUseCase(impl: UpdateContactsToDatabaseUseCaseImpl): UpdateContactsToDatabaseUseCase

    @[Binds]
    fun bindUpdateToApiContactUseCase(impl: UpdateContactToApiUseCaseImpl): UpdateContactToApiUseCase
}